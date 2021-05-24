package br.com.digital.innovation.one.novidadesjava11;

import java.util.Collection;
import java.util.Set;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 23/mai/2021 - 22:41
 */
public class CollectionExemplo {
  public static void main(String[] args) {
    Collection<String> nome = Set.of("Antonio", "Paulo", "Rodrigo", "Oliveira");

    System.out.println(nome);
  }
}
