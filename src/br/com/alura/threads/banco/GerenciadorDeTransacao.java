package br.com.alura.threads.banco;

public class GerenciadorDeTransacao {

  public void begin() {
    System.out.println("Começando a transação");

    try {
      Thread.sleep(5000L);
    } catch (final InterruptedException ex) {
      ex.printStackTrace();
    }
  }

}
