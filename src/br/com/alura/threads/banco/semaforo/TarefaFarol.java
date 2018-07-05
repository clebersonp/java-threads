package br.com.alura.threads.banco.semaforo;

public abstract class TarefaFarol {

  protected void dormir(final long millis) {
    try {
      Thread.sleep(millis);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }
}
