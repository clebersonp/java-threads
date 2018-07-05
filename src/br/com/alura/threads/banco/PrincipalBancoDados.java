package br.com.alura.threads.banco;

public class PrincipalBancoDados {

  public static void main(final String[] args) {

    final GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
    final PoolDeConexao pool = new PoolDeConexao();

    new Thread(new TarefaAcessoBanco(pool, tx), "Acesso ao Banco").start();
    new Thread(new TarefaAcessoProcedure(pool, tx), "Acesso a Procedure").start();

  }

}
