package br.com.digital.innovation.one.interfacesfuncionais;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Aula 2 Curso Digital Innovation One, revendo a Interface Stream.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 22/mai/2021 - 01:04
 */
public class Iteracoes {
  public static void main(String[] args) {
    String[] nomes = {"Antônio", "Antônio", "Lima", "Júnior", "Instrutor", "Java"};
    Integer[] numeros = {1, 2, 3, 4, 5};

    System.out.println("*** IMPRIMIR NOME FILTRADO ***");
    imprimirNomesFiltrados(nomes);
    System.out.println("\n*** IMPRIMIR TODOS OS NOMES ***");
    imprimirTodosNomes(nomes);
    System.out.println("\n*** IMPRIMIR O DOBRO DE CADA NUMERO ***");
    imprimirODobroDeCadaItemDaLista(numeros);

    List<String> career = new ArrayList<>();
    career.add("Developer");
    career.add("tester");
    career.add("ProjectManager");
    career.add("QualityManager");

    System.out.println("\n*** IMPRIMIR CAREER FILTRADA ***");
    career.stream()
        .filter(work -> work.equalsIgnoreCase("Developer"))
        .forEach(System.out::println);
  }

  public static void imprimirNomesFiltrados(String... nomes) {
    StringBuilder nomesParaImprimir = new StringBuilder();
    for (String s : nomes) {
      if (s.equals("Antônio")) {
        nomesParaImprimir.append(s);
      }
    }

    System.out.println("Resultado do for --> " + nomesParaImprimir);
    /*
      Stream possui vários métodos muito utilizados para iterar em coleções como filtros,
      iterators(como o peek), min, max... verificar documentação que contém todos os métodos.
     */

    String antonio = Stream.of(nomes)
        .filter(nome -> nome.equalsIgnoreCase("Antônio"))
        .collect(Collectors.joining());

    System.out.println("Resultado da API Stream --< " + antonio);
  }

  public static void imprimirTodosNomes(String... nomes) {
    for (String nome : nomes) {
      System.out.println("Resultado do For --> " + nome);
    }

    Stream.of(nomes)
        .forEach(nome -> System.out.println("Resultado da API Stream --> " + nome));
    // .forEach(System.out::println);
  }

  public static void imprimirODobroDeCadaItemDaLista(Integer... numeros) {
    for (Integer numero : numeros) {
      System.out.println("Resultado do For --> " + numero * 2);
    }
    Stream.of(numeros)
        .map(numero -> numero * 2)
        .forEach(numero -> System.out.println("Resultado da API Stream --> " + numero));
    // .forEach(System.out::println);
  }
}
