package br.com.digital.innovation.one.interfacesfuncionais;

/**
 * Aula 2 do curso Java Avançado da Digital Innovation One.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 21/mai/2021 - 22:46
 */
public class FuncaoAltaOrdem {
  public static void main(String[] args) {
    Calculo somar = (a, b) -> a + b;
    Calculo subtrair = (a, b) -> a - b;
    Calculo divisao = (a, b) -> a / b;
    Calculo multip = (a, b) -> a * b;

    System.out.println(execultarOperacao(somar, 1, 3));
    System.out.println(execultarOperacao(subtrair, 1, 3));
    System.out.println(execultarOperacao(divisao, 10, 3));
    System.out.println(execultarOperacao(multip, 1, 3));
  }

  /**
   * Definição de Função de Alta Ordem - Função que retorna uma função ou recebe
   * Uma como parâmetro.
   * Método para executar todas a funções lambda criadas da interface Cálculo.
   *
   * @param calculo Instancia lambda da Interface Calculo
   * @param a Parâmetro que que deve ser calculado
   * @param b Parâmetro que que deve ser calculado
   * @return Retorna um inteiro fruto do cálculo criado nas funções lambda
   */
  public static double execultarOperacao(Calculo calculo, int a, int b) {
    return calculo.calculo(a, b);
  }
}

/**
 * Interface funcional para criação de função lambda.
 */
@FunctionalInterface
interface Calculo {
  double calculo(int num1, int num2);
}
