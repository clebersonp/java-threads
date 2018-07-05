package br.com.alura.threads.banco;

public class TarefaAcessoBanco implements Runnable {

  private final PoolDeConexao pool;
  private final GerenciadorDeTransacao tx;

  public TarefaAcessoBanco(final PoolDeConexao pool, final GerenciadorDeTransacao tx) {
    this.pool = pool;
    this.tx = tx;
  }

  @Override
  public void run() {
    final String name = Thread.currentThread().getName();

    // DEAD LOCK pois esta invertido na classe TarefaAcessoProcedure

    synchronized (this.pool) {
      System.out.format("%s - peguei a chave do pool...%n", name);
      this.pool.getConnection();

      synchronized (this.tx) {
        System.out.format("%s - começando gerenciar a tx...%n", name);
        this.tx.begin();
      }
    }
  }

}
