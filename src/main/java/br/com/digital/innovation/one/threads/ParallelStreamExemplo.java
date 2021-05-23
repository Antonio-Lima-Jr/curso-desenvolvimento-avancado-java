package br.com.digital.innovation.one.threads;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Entendendo a função parallel da API Stream.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 22/mai/2021 - 20:06
 */
public class ParallelStreamExemplo {
  public static void main(String[] args) {
    System.out.println("Sem PARALLEL");
    long inicio = System.currentTimeMillis();
    IntStream.range(1, 100000).forEach(ParallelStreamExemplo::fatorial); // Serial Stream
    long fim = System.currentTimeMillis();
    System.out.println("Tempo de execução " + (fim - inicio) + " Milissegundo");


    System.out.println("\nUtilizando PARALLEL");
    inicio = System.currentTimeMillis();
    IntStream.range(1, 100000).parallel().forEach(ParallelStreamExemplo::fatorial); // Pararell
    fim = System.currentTimeMillis();
    System.out.println("Tempo de execução " + (fim - inicio) + " Milissegundo");

    List<String> nomes = Arrays.asList("João", "Paulo", "Oliveira", "Santos");
    // Percebemos que a saida não esta na ordem da lista, pois o foreach vai cuspido paralelamente os itens da lista.
    nomes.parallelStream().forEach(System.out::println);
  }

  public static double fatorial(long num) {
    double fat = 1;

    for (int i = 2; i <= num; i++) {
      fat *= i;
    }
    return fat;
  }
}
