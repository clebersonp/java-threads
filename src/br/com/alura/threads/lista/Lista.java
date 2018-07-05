package br.com.alura.threads.lista;

public class Lista {

  private final String[] elementos = new String[10000];
  private int posicao = 0;

  // Metodo que sera executado em concorrencia entre as threads tem que ser sincronizado(multex,
  // chave locked)
  public synchronized void adicionarElemento(final String elemento) {
    this.elementos[this.posicao] = elemento;
    this.posicao++;

    this.dormir(1L);
    this.notificar();

  }

  private void notificar() {
    if (this.estaCheia()) {
      this.notify();
    }
  }

  public boolean estaCheia() {
    return this.posicao == this.elementos.length;
  }

  public int getTamanho() {
    return this.elementos.length;
  }

  public String recuperarElemento(final int posicao) {
    return this.elementos[posicao];
  }

  private void dormir(final long millis) {
    try {
      Thread.sleep(millis);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }
}
