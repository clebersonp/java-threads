package br.com.alura.threads.calculadora;

import javax.swing.JLabel;

public class EsperaDoCalculador implements Runnable {

  private final JLabel resultado;

  public EsperaDoCalculador(final JLabel resultado) {
    this.resultado = resultado;
  }

  @Override
  public void run() {

    while (true) {
      try {
        this.resultado.setText("Calculando");
        Thread.sleep(800);
        this.resultado.setText("Calculando.");
        Thread.sleep(800);
        this.resultado.setText("Calculando..");
        Thread.sleep(800);
        this.resultado.setText("Calculando...");
        Thread.sleep(800);
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

}
