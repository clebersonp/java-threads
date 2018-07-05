package br.com.alura.threads.lista;

public class Principal {

  public static void main(final String[] args) throws InterruptedException {

    // final List<String> lista = new ArrayList<>(); nao sincronizado
    // final List<String> lista = Collections.synchronizedList(new ArrayList<>());
    // final List<String> lista = new Vector<>(); // tbm e sincronizado
    final Lista lista = new Lista();

    System.out.println("Adicionando elementos no array....");
    for (int i = 0; i < 10; i++) {
      new Thread(new TarefaAdicionarElementos(lista), String.format("Thread %d", i)).start();
    }

    new Thread(new TarefaImprimir(lista), "Thread Imprime Lista").start();

  }
}
