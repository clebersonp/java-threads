package br.com.alura.threads.banco;

public class PoolDeConexao {

  public String getConnection() {
    System.out.println("Emprestando conexão");

    try {
      Thread.sleep(5000L);
    } catch (final InterruptedException ex) {
      ex.printStackTrace();
    }

    return "connection";
  }

}
