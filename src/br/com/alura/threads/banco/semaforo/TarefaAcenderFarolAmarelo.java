package br.com.alura.threads.banco.semaforo;

public class TarefaAcenderFarolAmarelo extends TarefaFarol implements Runnable {

  private final Semaforo semaforo;

  public TarefaAcenderFarolAmarelo(final Semaforo semaforo) {
    this.semaforo = semaforo;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (this.semaforo) {
        if (this.semaforo.isFarolVerdeAceso()) {
          System.out.println("Acendendo o farol amarelo...");
          this.semaforo.ascenderFarolAmarelo();
          this.dormir(1000L);
        }
      }
    }
  }
}
