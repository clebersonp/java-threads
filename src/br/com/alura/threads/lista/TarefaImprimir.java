package br.com.alura.threads.lista;

public class TarefaImprimir implements Runnable {

  private final Lista lista;

  public TarefaImprimir(final Lista lista) {
    this.lista = lista;
  }

  @Override
  public void run() {

    synchronized (this.lista) {

      while (not(this.lista.estaCheia())) {
        try {
          System.out.println("Esperando a lista estar cheia....");
          this.lista.wait();
        } catch (final InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println("Imprimindo lista...");
      for (int i = 0; i < this.lista.getTamanho(); i++) {
        System.out.format("%d - %s %n", i, this.lista.recuperarElemento(i));
      }
    }
  }

  private static boolean not(final boolean expression) {
    return !expression;
  }

}
