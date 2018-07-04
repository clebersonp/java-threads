package br.com.alura.threads.banheiro;

public class TarefaNumero2 implements Runnable {

  private final Banheiro banheiro;

  public TarefaNumero2(final Banheiro banheiro) {
    this.banheiro = banheiro;
  }

  @Override
  public void run() {
    this.banheiro.fazerNumero2();
  }
}
