package br.com.alura.threads.banco.semaforo;

public class TarefaAcenderFarolVermelho extends TarefaFarol implements Runnable {

  private final Semaforo semaforo;

  public TarefaAcenderFarolVermelho(final Semaforo semaforo) {
    this.semaforo = semaforo;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (this.semaforo) {
        if (this.semaforo.isFarolAmareloAceso()) {
          System.out.println("Acendendo o farol vermelho...");
          this.semaforo.ascenderFarolVermelho();
          this.dormir(1000L);
        }
      }
    }
  }
}
