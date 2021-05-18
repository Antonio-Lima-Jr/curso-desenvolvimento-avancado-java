package br.com.digital.innovation.one.paradigmafuncional;

/**
 * Interface Funcional com contrato de método para gerar lambdas.
 */
@FunctionalInterface
interface Funcao {
  /**
   * Método utilizado para gerar pronomes de tratamento.
   *
   * @param nome parâmetro nome que vai ser concatenado
   * @return retorna o nome concatenado com um pronome de tratamento
   */
  String concatenarPronome(String nome);
}

/**
 * Aula sobre interfaces Funcionais,
 * mostra a forma em que era usada
 * funções isoladas de classes antes
 * do Java 8 e a utilização
 * com lambdas após o java 8.
 *
 * @author Antônio Lima Jr
 * @created 18/05/2021 - 15:28
 * @project curso-desenvolvimento-avancado-em-java
 */
public class AulaFunctionalInterface {

  public static void main(String[] args) {

    // Utilizando método de classe anónima utilizado antes do java 8
    Funcao gerarUmaSaidaComSrNaString = new Funcao() {
      @Override
      public String concatenarPronome(String nome) {
        return "Sr." + nome;
      }
    };
    System.out.println(gerarUmaSaidaComSrNaString.concatenarPronome("Antonio"));

    // Utilizando lambda após atualização do Java 8
    Funcao gerarSaidaComSrNaStringUtilizandoLambda = nome -> "Sr." + nome;

    System.out.println(
        gerarSaidaComSrNaStringUtilizandoLambda
            .concatenarPronome("Antonio Utilizando lambda")
    );
  }
}
