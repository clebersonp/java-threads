package br.com.alura.threads.numeros;

public class ImprimeNumeros {

  public static void main(final String[] args) {

    final Thread thread1 = new Thread(new ImpressorNumeros());
    final Thread thread2 = new Thread(new ImpressorNumeros());

    thread1.start();
    thread2.start();
  }
}
