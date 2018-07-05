package br.com.alura.threads.lista;

public class TarefaAdicionarElementos implements Runnable {

  private final Lista lista;

  public TarefaAdicionarElementos(final Lista lista) {
    this.lista = lista;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      final String nomeThread = Thread.currentThread().getName();
      this.lista.adicionarElemento(String.format("%s - posicao %d", nomeThread, i));
    }
  }
}
