package br.com.digital.innovation.one.novidadesjava11;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 23/mai/2021 - 22:13
 */
public class StringIsBlankExemplo {
  public static void main(String[] args) {
    String espaco = " ";
    System.out.println(espaco != null && espaco.length() > 0 && espaco.chars().allMatch(c -> c == ' '));
    System.out.println(espaco.isBlank());
  }

}
