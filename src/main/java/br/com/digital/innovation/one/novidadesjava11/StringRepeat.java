package br.com.digital.innovation.one.novidadesjava11;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 23/mai/2021 - 22:44
 */
public class StringRepeat {

  public static void main(String[] args) {
    String nome = "Antônio";
    System.out.println(nome.repeat(10));
  }

  public static void equivalenteARepete() {
    String aux = "";
    String nome = "Antônio";

    for (int i = 0; i < 10; i++) {
      aux += nome;
    }
    System.out.println(aux);
  }

}
