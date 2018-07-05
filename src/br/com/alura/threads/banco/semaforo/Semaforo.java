package br.com.alura.threads.banco.semaforo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Semaforo extends JFrame {

  private static final long serialVersionUID = -2656602607634787904L;
  private Component farolVermelho;
  private Component farolAmarelo;
  private Component farolVerde;

  private Semaforo() {
    this.configurarJanela();
  }

  public static Semaforo abrirJanela() {
    return new Semaforo();
  }

  private void configurarJanela() {
    this.criarFarois();
    this.add(this.criarPainel());
    this.setTitle("Semáforo controlado por Threads");
    this.setBounds(new Rectangle(500, 300, 0, 0));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  private JPanel criarPainel() {
    final JPanel panel = new JPanel();
    panel.add(this.farolVermelho);
    panel.add(this.farolAmarelo);
    panel.add(this.farolVerde);
    return panel;
  }

  private void criarFarois() {
    final Component vermelho = new Canvas();
    vermelho.setSize(150, 100);
    vermelho.setBackground(Color.WHITE);

    final Component amarelo = new Canvas();
    amarelo.setSize(150, 100);
    amarelo.setBackground(Color.YELLOW);

    final Component verde = new Canvas();
    verde.setSize(150, 100);
    verde.setBackground(Color.WHITE);

    this.farolVermelho = vermelho;
    this.farolAmarelo = amarelo;
    this.farolVerde = verde;
  }

  public synchronized void ascenderFarolVermelho() {
    this.farolVermelho.setBackground(Color.RED);
    this.farolAmarelo.setBackground(Color.WHITE);
    this.farolVerde.setBackground(Color.WHITE);
  }

  public synchronized void ascenderFarolAmarelo() {
    this.farolVermelho.setBackground(Color.WHITE);
    this.farolAmarelo.setBackground(Color.YELLOW);
    this.farolVerde.setBackground(Color.WHITE);
  }

  public synchronized void ascenderFarolVerde() {
    this.farolVermelho.setBackground(Color.WHITE);
    this.farolAmarelo.setBackground(Color.WHITE);
    this.farolVerde.setBackground(Color.GREEN);
  }

  public synchronized boolean isFarolVermelhoAceso() {
    return this.farolVermelho.getBackground().equals(Color.RED);
  }

  public synchronized boolean isFarolAmareloAceso() {
    return this.farolAmarelo.getBackground().equals(Color.YELLOW);
  }

  public synchronized boolean isFarolVerdeAceso() {
    return this.farolVerde.getBackground().equals(Color.GREEN);
  }

}
