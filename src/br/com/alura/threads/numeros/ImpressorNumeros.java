package br.com.alura.threads.numeros;

public class ImpressorNumeros implements Runnable {

  @Override
  public void run() {
    for (int i = 1; i <= 1000; i++) {
      final Thread currentThread = Thread.currentThread();
      System.out.format("ID: %d, Número: %d %n", currentThread.getId(), i);
    }
  }
}
