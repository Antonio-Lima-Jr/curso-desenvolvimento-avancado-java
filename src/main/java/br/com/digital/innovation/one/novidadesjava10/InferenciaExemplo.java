package br.com.digital.innovation.one.novidadesjava10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 23/mai/2021 - 12:36
 */
public class InferenciaExemplo {


  public static void main(String[] args) throws IOException {

    testar("João", "Paulo");
    printerSoma(10, 20);

  }

  private static void printerSoma(int a, int b) {
    var resultado = a + b;
    System.out.println(resultado);
  }

  private static void connectAndPrintURLJavaOracle() throws IOException {


    /*
    Try with resource - quem implementar a classe Closeable, pode ser passada para o parentheses abaixo
    para ser fechado automaticamente quando sair do try;
     */
    var url = new URL("https://docs.oracle.com/javase/10/language/");
    var urlConnection = url.openConnection();
    try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
      System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
    }

  }

  private static void testar(String nome, String sobrenome) {
    var nomeCompleto = nome + sobrenome;
    System.out.println(nomeCompleto);
  }
  // Conseguimos

  // var sempre deve estar dentro de um escopo, um método, um while, for, if, else ...
  // variável suporte do enhanced for
  // variável suporte do for iterativo

  // Não conseguimos

  // var não pode ser utilizado em nível de classe
  // var não pode ser utilizado como parâmetro de métodos
  // Nao pode ser utilizada em variáveis locais não inicializada
}
