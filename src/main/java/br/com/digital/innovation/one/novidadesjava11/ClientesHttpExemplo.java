package br.com.digital.innovation.one.novidadesjava11;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Demonstra a velocidade do novo protocolo http2 em relação ao 1.1.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 23/mai/2021 - 14:48
 */
public class ClientesHttpExemplo {

  static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
    @Override
    public Thread newThread(Runnable runnable) {
      Thread thread = new Thread(runnable);
      System.out.println("Nova thread criada :: " + (thread.isDaemon() ? "daemon" : "") + " Thread Group :: " + thread.getThreadGroup());
      return thread;
    }
  });

  public static void main(String[] args) throws Exception {

    connectAkamaiHttp_2Cliente();
  }

  private static void connectAkamaiHttp1_1Cliente() {
    System.out.println("Running HTTP/1.1 example ...");
    try {
      HttpClient httpClient = HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_1_1)
          .proxy(ProxySelector.getDefault())
          .build();

      long start = System.currentTimeMillis();

      HttpRequest mainRequest = HttpRequest
          .newBuilder()
          .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
          .build();

      HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

      System.out.println("Status code :: " + response.statusCode());
      System.out.println("Response Headers :: " + response.headers());
      String responseBody = response.body();
      System.out.println(responseBody);

      List<Future<?>> future = new ArrayList<>();

      responseBody.lines()
          .filter(line -> line.trim().startsWith("<img height"))
          .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
          .forEach(image -> {
            Future<?> imgFuture = executor.submit(() -> {
              HttpRequest imgRequest = HttpRequest.newBuilder()
                  .uri(URI.create("https://http2.akamai.com" + image))
                  .build();

              try {
                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                System.out.println("Image Carregada :: " + image + ", status code :: " + imageResponse.statusCode());
              } catch (IOException | InterruptedException e) {
                System.out.println("Mensagem de erro durante a requisição para a imagem" + image);
                e.printStackTrace();
              }
            });
            future.add(imgFuture);
            System.out.println("Submetidas de future para imagem :: " + image);
          });

      future.forEach(f -> {
        try {
          f.get();

        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
        }
      });

      long end = System.currentTimeMillis();
      System.out.println("Tempo de carregamento total :: " + (end - start));

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }
  }

  private static void connectAkamaiHttp_2Cliente() {
    System.out.println("Running HTTP/2.0 example ...");
    try {
      HttpClient httpClient = HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_2)
          .proxy(ProxySelector.getDefault())
          .build();

      long start = System.currentTimeMillis();

      HttpRequest mainRequest = HttpRequest
          .newBuilder()
          .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
          .build();

      HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

      System.out.println("Status code :: " + response.statusCode());
      System.out.println("Response Headers :: " + response.headers());
      String responseBody = response.body();
      System.out.println(responseBody);

      List<Future<?>> future = new ArrayList<>();

      responseBody.lines()
          .filter(line -> line.trim().startsWith("<img height"))
          .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
          .forEach(image -> {
            Future<?> imgFuture = executor.submit(() -> {
              HttpRequest imgRequest = HttpRequest.newBuilder()
                  .uri(URI.create("https://http2.akamai.com" + image))
                  .build();
              try {
                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                System.out.println("Image Carregada :: " + image + ", status code :: " + imageResponse.statusCode());
              } catch (IOException | InterruptedException e) {
                System.out.println("Mensagem de erro durante a requisição para a imagem" + image);
                e.printStackTrace();
              }
            });
            future.add(imgFuture);
            System.out.println("Submetidas de future para imagem :: " + image);
          });

      future.forEach(f -> {
        try {
          f.get();

        } catch (InterruptedException | ExecutionException e) {
          e.printStackTrace();
        }
      });

      long end = System.currentTimeMillis();
      System.out.println("Tempo de carregamento total :: " + (end - start));

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }
  }

  private static void connectAndPrintURLJavaOracle11() throws IOException, InterruptedException {
    HttpRequest req = HttpRequest.newBuilder()
        .GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
        .build();

    HttpClient httpClient = HttpClient.newHttpClient();
    HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    System.out.println("Status code :: " + res.statusCode());
    System.out.println("Headers res :: " + res.headers());
    System.out.println(res.body());
  }
}
