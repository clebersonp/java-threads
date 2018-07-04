package br.com.alura.threads.banheiro;

public class UsoBanheiroTeste {

  public static void main(final String[] args) {
    final Banheiro banheiro = new Banheiro();

    final Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
    final Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Maria");
    final Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
    limpeza.setPriority(Thread.MAX_PRIORITY);
    limpeza.setDaemon(true); // marca para matar a jvm se a única thread executando for essa.
    // Uma thread daemon é uma prestador de serviços para outras threads. Ela só é usada enquanto as
    // outras threads estão rodando
    // final Thread convidado3 = new Thread(new TarefaNumero2(banheiro), "Marcus");
    // final Thread convidado4 = new Thread(new TarefaNumero1(banheiro), "Allan");

    convidado1.start();
    convidado2.start();
    limpeza.start();
    // convidado3.start();
    // convidado4.start();
  }
}
