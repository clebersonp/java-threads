package br.com.alura.threads.banco;

public class TarefaAcessoProcedure implements Runnable {

  private final PoolDeConexao pool;
  private final GerenciadorDeTransacao tx;

  public TarefaAcessoProcedure(final PoolDeConexao pool, final GerenciadorDeTransacao tx) {
    this.pool = pool;
    this.tx = tx;
  }

  @Override
  public void run() {
    final String name = Thread.currentThread().getName();

    // DEAD LOCK pois esta invertido na classe TarefaAcessoBanco

    synchronized (this.tx) {
      System.out.format("%s - começando a tx...%n", name);
      this.tx.begin();

      synchronized (this.pool) {
        System.out.format("%s - peguei a conexão...%n", name);
      }
    }

  }

}
