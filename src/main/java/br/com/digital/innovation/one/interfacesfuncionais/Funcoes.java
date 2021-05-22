package br.com.digital.innovation.one.interfacesfuncionais;

import java.util.function.Function;

/**
 * Aula 2 Curso Digital Innovation One, entendendo com funciona a Interface Function.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 22/mai/2021 - 00:00
 */
public class Funcoes {
  public static void main(String[] args) {
    /*
      O primeiro Tipo Generics passado a Function é o parametro de entrada passado para a lambda.
      o segundo Tipo Generics é o valor que a lambda vai retornar.
     */
    Function<String, String> retornaNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
    // Function<Integer, String> converterStringEmInteger = string -> String.valueOf(string);
    Function<Integer, String> converterIntegerEmString = String::valueOf;
    Function<String, Integer> converterStringEmInteger = Integer::valueOf;
    // Converter para int e calcular o dobro, é usado o parseInt para converter em um tipo primitivo e o ValueOf converte em Tipo Wrapper.
    Function<String, Integer> converterParaIntegerECalcularDobro = string -> Integer.parseInt(string) * 2;

    System.out.println(retornaNomeAoContrario.apply("Antônio"));
    System.out.println(converterIntegerEmString.apply(10) + " do Tipo: " + converterIntegerEmString.apply(10).getClass().getSimpleName());
    System.out.println(converterStringEmInteger.apply("10") + " do Tipo: " + converterStringEmInteger.apply("10").getClass().getSimpleName());
    System.out.println(converterParaIntegerECalcularDobro.apply("10") + " do Tipo: " + converterParaIntegerECalcularDobro.apply("10").getClass().getSimpleName());
  }
}
