class Fila<T> {
    private T[] fila;
    private int capacidade;
    private int frente, tras, tamanho;
    private static final int tam_padrao = 100;

    public Fila() {
        this(tam_padrao);
    }

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.fila = (T[]) new Object[capacidade];
        this.frente = 0;
        this.tras = -1;
        this.tamanho = 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void enqueue(T elemento) {
        if (isFull()) {
            System.out.println("Erro: Fila cheia!");
            return;
        }
        tras = (tras + 1) % capacidade;
        fila[tras] = elemento;
        tamanho++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Erro: Fila vazia!");
            return null;
        }
        T elementoRemovido = fila[frente];
        frente = (frente + 1) % capacidade;
        tamanho--;
        return elementoRemovido;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Erro: Fila vazia!");
            return null;
        }
        return fila[frente];
    }

    public void mostrarFila() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(fila[(frente + i) % capacidade] + " ");
        }
        System.out.println();
    }
}
