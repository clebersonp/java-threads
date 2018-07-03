package br.com.alura.threads.leitor;

public class LeituraTexto {

  public static void main(final String[] args) {

    // \\s white space, \\w caracter ou number
    final String expRegular = "(Dan|Chad)(\\s|\\w)*";

    final Thread threadAssinaturas1 = new Thread(new LeitorTexto("assinaturas1.txt", expRegular));
    final Thread threadAssinaturas2 = new Thread(new LeitorTexto("assinaturas2.txt", expRegular));
    final Thread threadAutores = new Thread(new LeitorTexto("autores.txt", expRegular));

    threadAssinaturas1.start();
    threadAssinaturas2.start();
    threadAutores.start();

  }

}
