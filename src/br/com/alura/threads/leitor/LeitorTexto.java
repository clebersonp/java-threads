package br.com.alura.threads.leitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorTexto implements Runnable {

  private final String nomeArquivo;
  private final String nome;

  public LeitorTexto(final String nomeArquivo, final String nome) {
    this.nomeArquivo = nomeArquivo;
    this.nome = nome;
  }

  @Override
  public void run() {

    try (final Scanner scanner = new Scanner(new File(this.nomeArquivo))) {

      int linha = 1;

      while (scanner.hasNextLine()) {
        final String texto = scanner.nextLine();
        if (texto.matches(this.nome)) {
          System.out.format("Arquivo: %s - Linha: %d %n", this.nomeArquivo, linha);
        }
        linha++;
      }

    } catch (final FileNotFoundException ex) {
      System.err.println(ex);
    }

  }

}
