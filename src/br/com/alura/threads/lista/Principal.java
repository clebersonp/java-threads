package br.com.alura.threads.lista;

import java.util.List;
import java.util.Vector;

public class Principal {

    public static void main(final String[] args) throws InterruptedException {

        // final List<String> lista = new ArrayList<>(); nao sincronizado
        // final List<String> lista = Collections.synchronizedList(new ArrayList<>());
        final List<String> lista = new Vector<>(); // tbm e sincronizado

        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElementos(lista), String.format("Thread %d", i)).start();
        }

        Thread.sleep(1500);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}
