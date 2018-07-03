package br.com.alura.threads.banheiro;

public class TarefaNumero1 implements Runnable {

  private final Banheiro banheiro;

  public TarefaNumero1(final Banheiro banheiro) {
    this.banheiro = banheiro;
  }

  @Override
  public void run() {
    final String nome = Thread.currentThread().getName();
    System.out.format("%s batendo na porta... %n-------------------%n", nome);
    this.banheiro.fazerNumero1();
  }
}
