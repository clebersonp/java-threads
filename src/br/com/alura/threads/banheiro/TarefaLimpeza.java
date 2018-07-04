package br.com.alura.threads.banheiro;

public class TarefaLimpeza implements Runnable {
  private final Banheiro banheiro;

  public TarefaLimpeza(final Banheiro banheiro) {
    this.banheiro = banheiro;
  }

  @Override
  public void run() {
    while (true) {
      this.banheiro.limpar();
      try {
        Thread.sleep(20000);
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
