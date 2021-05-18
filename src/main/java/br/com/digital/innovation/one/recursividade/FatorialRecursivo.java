package br.com.digital.innovation.one.recursividade;

/**
 * Classe faz o fatorial de uma forma recursiva.
 *
 * @author Antônio Lima Jr
 * @created 18/05/2021 - 17:12
 * @project curso-desenvolvimento-avancado-em-java
 */
public class FatorialRecursivo {
  public static void main(String[] args) {

    System.out.println(fatorial(5));

  }

  /**
   * Método para fazer o fatorial recursivo.
   *
   * @param value atributo passado para o método calcular.
   * @return retorna o valor fatorial de um numero
   */
  public static int fatorial(int value) {
    if (value == 1) {
      return value;
    } else {
      return value * fatorial(value - 1);
    }
  }

}
