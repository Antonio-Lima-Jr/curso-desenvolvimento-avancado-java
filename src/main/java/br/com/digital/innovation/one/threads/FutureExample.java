package br.com.digital.innovation.one.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Classe com o objetivo de exemplificar como o ExecultorService pode executar uma lista de
 * funções assincronamente.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 22/mai/2021 - 16:02
 */
public class FutureExample {
  private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

  public static void main(String[] args) throws InterruptedException {
    Casa casa = new Casa(new Quarto());
    /*
    o método execute do ExecultorService cria Thread para funções sem retorno assim não é possivel de
    verificar o andamento da Thread.
     */
    // casa.obterAfazeresDaCasa().forEach(atividade -> threadPool.execute(() -> atividade.realizar()));

    /*
    O Método submit do ExecultorService ativa uma Thread com a função passada a ela e retorna um objeto do Tipo Future
    que podemos acessar algumas informações da Thread criada.
    Como implementado abaixo future.isDone que retorna True se a Thread já tiver sido concluída
    ou o future.get() que retorna o retorno implementado na lambda que foi chamada na Thread.
     */
    List<? extends Future<String>> futures = casa.obterAfazeresDaCasa()
        .stream()
        .map(atividade -> threadPool.submit(atividade::realizar))
        .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

    int numeroAtividadesFinalizadas = 0;
    while (true) {

      for (Future<?> future : futures) {
        System.out.println(future.toString());
        if (future.isDone()) {
          try {
            System.out.println("Parabéns voce terminou de : " + future.get());
            futures.remove(future);
            numeroAtividadesFinalizadas++;
          } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
          }
        }
      }

      System.out.println("Numero de atividades finalizadas: " + numeroAtividadesFinalizadas);

      if (futures.stream().allMatch(Future::isDone)) {
        break;
      }
      Thread.sleep(500);

    }
    threadPool.shutdown();
  }
}

/**
 * Casa recebe uma lista de cômodos através de um arrayArgs.
 */
class Casa {
  private List<Comodo> comandos;

  public Casa(Comodo... comandos) {
    this.comandos = Arrays.asList(comandos);
  }

  /**
   * itera todos os cômodos e cria uma lista com todos os afazeres de todos os cômodos.
   *
   * @return Retorna uma lista de afazeres de todos os cômodos passados para a casa
   */
  List<Atividade> obterAfazeresDaCasa() {
    return this.comandos.stream().map(Comodo::obterAfazeresDoComodo)
        .reduce(new ArrayList<>(), (pivo, atividades) -> {
          pivo.addAll(atividades);
          return pivo;
        });
  }
}

/**
 * Esta classe serve para implementar as funções Lambda retornando uma lista de atividades.
 */
class Quarto extends Comodo {
  /**
   * Sobre escreve o método de Comodo que retorna uma lista de atividades
   * lembrando que atividade é um interface funcional assim pode ser implementada
   * através de lambdas.
   *
   * @return Retorna uma lista de funções implementadas como lambda de Atividade
   */
  @Override
  List<Atividade> obterAfazeresDoComodo() {
    return Arrays.asList(
        this::arrumarACama,
        this::varrerOQuarto,
        this::arrumarGuardaRoupa
    );
  }

  /**
   * Função que vai ser usada como lambda de atividade
   */
  private String arrumarGuardaRoupa() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Arrumar o guarda roupa " + Thread.currentThread();
  }

  /**
   * Função que vai ser usada como lambda de atividade
   */
  private String varrerOQuarto() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Varrer o Quarto " + Thread.currentThread();
  }

  /**
   * Função que vai ser usada como lambda de atividade
   */
  private String arrumarACama() {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "Arrumar a cama " + Thread.currentThread();
  }
}

/**
 * classe que deve sem estendida por todas as classes que deverão retornar uma lista de atividades.
 */
abstract class Comodo {
  abstract List<Atividade> obterAfazeresDoComodo();
}

/**
 * Interface Funcional criado com o intuito de ser um contrato para criação de funções lambda
 */
@FunctionalInterface
interface Atividade {
  String realizar();
}


