package br.com.digital.innovation.one.novidadesjava11;

import java.util.function.Function;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 23/mai/2021 - 21:42
 */
public class InferenciaLambda {
  public static void main(String[] args) {
    Function<Integer, Double> divisaoPor2 = (var numero) -> numero / 2.0;
    System.out.println(divisaoPor2.apply(9849367));
  }

}
