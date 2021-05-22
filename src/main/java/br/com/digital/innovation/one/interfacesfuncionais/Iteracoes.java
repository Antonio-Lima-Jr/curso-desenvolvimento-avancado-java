package br.com.digital.innovation.one.interfacesfuncionais;

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
    imprimirNomesFiltrados(nomes);
    imprimirTodosNomes(nomes);
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
      <p>Stream possui vários métodos muito utilizados para iterar em coleções como filtros,
      iterators(como o peek), min, max... verificar <a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html">documentação</a> que contém todos os métodos.
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
}
