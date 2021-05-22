package br.com.digital.innovation.one.interfacesfuncionais;

import java.util.function.Consumer;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 21/mai/2021 - 23:30
 */
public class Consumidores {
  public static void main(String[] args) {
    /**
     * Interface Consumer cria uma função lambda onde podemos passar o parâmetro.
     * Usando o método accept.
     */

    // Consumer<String> imprimeUmaFrase = frase -> System.out.println(frase);
    Consumer<String> imprimeUmaFrase = System.out::println;
    imprimeUmaFrase.accept("Hello World");
  }


}
