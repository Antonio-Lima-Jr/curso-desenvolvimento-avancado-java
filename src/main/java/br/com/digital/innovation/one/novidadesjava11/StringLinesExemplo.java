package br.com.digital.innovation.one.novidadesjava11;

import java.util.stream.Collectors;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 23/mai/2021 - 22:33
 */
public class StringLinesExemplo {
  public static void main(String[] args) {
    String html = "<html>" +
        "\n<head>" +
        "\n</head>" +
        "\n <body>" +
        "\n </body>" +
        "\n</html>";
    System.out.println(html.lines().filter(s -> s.contains("head")).collect(Collectors.joining()));
  }
}
