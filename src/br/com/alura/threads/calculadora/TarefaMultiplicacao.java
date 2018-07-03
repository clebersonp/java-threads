package br.com.alura.threads.calculadora;

import java.math.BigInteger;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TarefaMultiplicacao implements Runnable {

  private final JTextField primeiro;
  private final JTextField segundo;
  private final JLabel resultado;
  private final Thread esperando;

  public TarefaMultiplicacao(final Thread esperando, final JTextField primeiro,
      final JTextField segundo, final JLabel resultado) {
    this.esperando = esperando;
    this.primeiro = primeiro;
    this.segundo = segundo;
    this.resultado = resultado;
  }

  @Override
  public void run() {
    final long valor1 = Long.parseLong(this.primeiro.getText());
    final long valor2 = Long.parseLong(this.segundo.getText());
    BigInteger calculo = new BigInteger("0");

    for (int i = 0; i < valor1; i++) {
      for (int j = 0; j < valor2; j++) {
        calculo = calculo.add(new BigInteger("1"));
      }
    }

    this.esperando.stop();
    this.resultado.setText(calculo.toString());
  }

}
