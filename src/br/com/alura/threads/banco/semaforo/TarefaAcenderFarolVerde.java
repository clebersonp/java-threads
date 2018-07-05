package br.com.alura.threads.banco.semaforo;

public class TarefaAcenderFarolVerde extends TarefaFarol implements Runnable {

  private final Semaforo semaforo;

  public TarefaAcenderFarolVerde(final Semaforo semaforo) {
    this.semaforo = semaforo;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (this.semaforo) {
        if (this.semaforo.isFarolVermelhoAceso()) {
          System.out.println("Acendendo o farol verde...");
          this.semaforo.ascenderFarolVerde();
          this.dormir(1000L);
        }
      }
    }
  }
}
