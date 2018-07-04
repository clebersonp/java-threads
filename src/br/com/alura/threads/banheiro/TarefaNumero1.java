package br.com.alura.threads.banheiro;

public class TarefaNumero1 implements Runnable {

  private final Banheiro banheiro;

  public TarefaNumero1(final Banheiro banheiro) {
    this.banheiro = banheiro;
  }

  @Override
  public void run() {
    this.banheiro.fazerNumero1();
  }
}
