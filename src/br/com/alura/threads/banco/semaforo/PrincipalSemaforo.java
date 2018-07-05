package br.com.alura.threads.banco.semaforo;

public class PrincipalSemaforo {

  public static void main(final String[] args) {

    final Semaforo semaforo = Semaforo.abrirJanela();

    new Thread(new TarefaAcenderFarolVermelho(semaforo), "Thread Farol vermelho").start();
    new Thread(new TarefaAcenderFarolVerde(semaforo), "Thread Farol verde").start();
    new Thread(new TarefaAcenderFarolAmarelo(semaforo), "Thread Farol amarelo").start();

  }

}
