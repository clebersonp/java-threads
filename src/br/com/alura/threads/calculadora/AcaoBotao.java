
package br.com.alura.threads.calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AcaoBotao implements ActionListener {

  private final JTextField primeiro;
  private final JTextField segundo;
  private final JLabel resultado;

  public AcaoBotao(final JTextField primeiro, final JTextField segundo, final JLabel resultado) {
    this.primeiro = primeiro;
    this.segundo = segundo;
    this.resultado = resultado;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {

    final Thread esperando =
        new Thread(new EsperaDoCalculador(this.resultado), "Thread Espera do Calculo");
    esperando.start();

    final TarefaMultiplicacao tarefa =
        new TarefaMultiplicacao(esperando, this.primeiro, this.segundo, this.resultado);
    final Thread calculadora = new Thread(tarefa, "Thread Calculadora");
    calculadora.start();
  }

}
