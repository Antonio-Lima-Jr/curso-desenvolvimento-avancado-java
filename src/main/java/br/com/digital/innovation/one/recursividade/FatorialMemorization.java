package br.com.digital.innovation.one.recursividade;

import java.util.HashMap;
import java.util.Map;

/**
 * Técnica Memorization com interface Map de collections.
 *
 * @author Antônio Lima Jr
 * @created 18/05/2021 - 17:36
 * @project curso-desenvolvimento-avancado-em-java
 */
public class FatorialMemorization {
  public static Map<Integer, Integer> MAPA_FATORIAL = new HashMap<>();

  public static void main(String[] args) {
    long I = System.nanoTime();
    System.out.println(fatorialComMemorization(15));
    long F = System.nanoTime();
    System.out.println("FATORIAL 1" + (F - I));

    I = System.nanoTime();
    System.out.println(fatorialComMemorization(15));
    F = System.nanoTime();
    System.out.println("FATORIAL 2" + (F - I));

  }

  /**
   * Faz o fatorial memorizando resultados anteriores.
   *
   * @param value valor que deve ser calculado o fatorial
   * @return retorna 1 para que a recursividade de certo
   */
  public static Integer fatorialComMemorization(Integer value) {
    if (value == 1) {
      return value;
    } else {
      if (MAPA_FATORIAL.containsKey(value)) {
        return MAPA_FATORIAL.get(value);
      } else {
        Integer resultado = value + fatorialComMemorization(value - 1);
        MAPA_FATORIAL.put(value, resultado);
        return resultado;
      }
    }
  }
}
