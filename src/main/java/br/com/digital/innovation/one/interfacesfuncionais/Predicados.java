package br.com.digital.innovation.one.interfacesfuncionais;

import java.util.function.Predicate;

/**
 * Aula 2 Curso Digital Innovation One, entendendo como funciona a Interface Predicate.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 22/mai/2021 - 00:33
 */
public class Predicados {
  public static void main(String[] args) {
    /*
    A interface Predicate sempre retorna um boolean,
    passo um parametro Generics, faço uma espécie de validação
    e retorno um boolean como resultado
     */
    Predicate<String> estaVazio = valor -> valor.isEmpty();
    System.out.println(estaVazio.test(""));
    System.out.println(estaVazio.test("Antônio"));
  }
}
