package br.com.alura.threads.banheiro;

public class Banheiro {

  public synchronized void fazerNumero1() {
    final String thread = Thread.currentThread().getName();

    System.out.format("%s entrando no banheiro %n", thread);
    System.out.format("%s fazendo numero1 rapido %n", thread);
    try {
      Thread.sleep(5000);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
    System.out.format("%s dando descarga %n", thread);
    System.out.format("%s lavando as mãos %n", thread);
    System.out.format("%s saindo do banheiro %n-------------------%n", thread);
  }

  public synchronized void fazerNumero2() {
    final String thread = Thread.currentThread().getName();

    System.out.format("%s entrando no banheiro %n", thread);
    System.out.format("%s fazendo numero2 demorado %n", thread);
    try {
      Thread.sleep(10000);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
    System.out.format("%s dando descarga %n", thread);
    System.out.format("%s lavando as mãos %n", thread);
    System.out.format("%s saindo do banheiro %n-------------------%n", thread);
  }
}
