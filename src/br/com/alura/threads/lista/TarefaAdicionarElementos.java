package br.com.alura.threads.lista;

import java.util.List;

public class TarefaAdicionarElementos implements Runnable {

    private final List<String> lista;

    public TarefaAdicionarElementos(final List<String> lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            final String nomeThread = Thread.currentThread().getName();
            this.lista.add(String.format("%s - posicao %d", nomeThread, i));
        }
    }

}
