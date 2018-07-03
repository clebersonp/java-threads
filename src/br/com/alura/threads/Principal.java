package br.com.alura.threads;

public class Principal {

  public static void main(final String[] args) throws InterruptedException {

    System.out.println("Thread main executando...");
    Thread.sleep(60000);
    System.out.println("Thread main terminou!");

  }

}
