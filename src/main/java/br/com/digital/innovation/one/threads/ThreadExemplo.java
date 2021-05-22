package br.com.digital.innovation.one.threads;

import static java.lang.Thread.sleep;

/**
 * Aula 2 Curso Digital Innovation One, Implementando Threads.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 22/mai/2021 - 11:08
 */
public class ThreadExemplo {
  public static void main(String[] args) {
    Thread geradorPDF = new Thread(new GeradorPDF());
    Thread barraDeCarregamento = new Thread(new BarraDeCarregamento(geradorPDF));

    geradorPDF.start();
    barraDeCarregamento.start();
    System.out.println("Nome da Thread: " + geradorPDF.getName());
    System.out.println("Nome da Thread1: " + barraDeCarregamento.getName());
  }
}

class GeradorPDF implements Runnable {

  @Override
  public void run() {
    try {
      sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Gerar PDF");
  }
}

class BarraDeCarregamento implements Runnable {

  private final Thread geradorPDF;

  public BarraDeCarregamento(Thread geradorPDF) {

    this.geradorPDF = geradorPDF;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (!geradorPDF.isAlive()) {
        break;
      }
      System.out.println("Loading...");
    }

  }
}
