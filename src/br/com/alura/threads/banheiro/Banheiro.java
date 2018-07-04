package br.com.alura.threads.banheiro;

public class Banheiro {

  private boolean ehSujo = true;

  public synchronized void fazerNumero1() {
    final String thread = Thread.currentThread().getName();
    System.out.format("%s batendo na porta... %n", thread);
    System.out.format("%s entrando no banheiro %n", thread);

    while (this.ehSujo) {
      this.esperaLaFora(thread);
    }

    System.out.format("%s fazendo numero1 rapido %n", thread);
    this.dormir(10000);
    System.out.format("%s dando descarga %n", thread);
    System.out.format("%s lavando as mãos %n", thread);
    System.out.format("%s saindo do banheiro %n", thread);

    this.sujarBanheiro();
  }

  public synchronized void fazerNumero2() {
    final String thread = Thread.currentThread().getName();
    System.out.format("%s batendo na porta... %n", thread);
    System.out.format("%s entrando no banheiro %n", thread);

    while (this.ehSujo) {
      this.esperaLaFora(thread);
    }

    System.out.format("%s fazendo numero2 demorado %n", thread);
    this.dormir(20000);
    System.out.format("%s dando descarga %n", thread);
    System.out.format("%s lavando as mãos %n", thread);
    System.out.format("%s saindo do banheiro %n", thread);

    this.sujarBanheiro();
  }



  public synchronized void limpar() {
    final String thread = Thread.currentThread().getName();
    System.out.format("%s batendo na porta... %n", thread);
    System.out.format("%s entrando no banheiro %n", thread);

    if (not(this.ehSujo)) {
      System.out.format("%s não precisou limpar o banheiro pois já está limpo! %n", thread);
      return;
    }

    this.ehSujo = false;

    System.out.format("%s limpando o banheiro %n", thread);
    System.out.format("%s liberando o banheiro %n", thread);
    System.out.format("%s saindo do banheiro %n", thread);

    this.notifyAll();
  }

  // se chamar esse metodo sera lancada uma exceçao IllegalMonitorStateException em tempo de Runtime
  // pois o metodo wait precisa estar em um bloco ou metodo synchronized
  public void normal() {
    try {
      this.wait();
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void esperaLaFora(final String thread) {
    System.out.format("%s, eca o banheiro está sujo %n", thread);
    try {
      this.wait();
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static boolean not(final boolean expression) {
    return !expression;
  }

  private void dormir(final long millis) {
    try {
      Thread.sleep(millis);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void sujarBanheiro() {
    this.ehSujo = true;
  }
}
