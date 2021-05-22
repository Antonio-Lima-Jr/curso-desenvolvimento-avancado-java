package br.com.digital.innovation.one.interfacesfuncionais;

import java.util.function.Supplier;

/**
 * Aula 2 Curso Digital Innovation One, entendendo com funciona a Interface Supplier.
 *
 * @author Antônio Lima Jr
 * @project curso-desenvolvimento-avancado-em-java
 * @created 22/mai/2021 - 00:49
 */
public class InterfaceSupplier {
  public static void main(String[] args) {
    // Supplier<Pessoa> suppliers = () -> new Pessoa();
    // Usando Metodo de referencia.
    Supplier<Pessoa> instanciaPessoa = Pessoa::new;

    System.out.println(instanciaPessoa.get());
  }
}

class Pessoa{
  private final String nome;
  private final Integer idade;

  public Pessoa() {
    this.nome = "João";
    this.idade = 23;
  }

  @Override
  public String toString() {
    return "Pessoa{" +
        "nome = '" + nome + '\'' +
        ", idade = " + idade +
        '}';
  }
}
