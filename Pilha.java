public class Pilha<T> {
    private int topoPilha;
    private T[] p;
    private static final int tam_padrao = 100;

    public Pilha(int tamanho) {
        this.p = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }

    public Pilha() { // Inicializa a pilha com um tamanho padrão
        this(tam_padrao);
    }

    public boolean isEmpty() { // Verifica se a pilha está vazia
        return this.topoPilha == -1;
    }

    public boolean isFull() { // Verifica se a pilha está cheia
        return this.topoPilha == this.p.length - 1;
    }

    public void push(T elemento) {
        if (!this.isFull()) {
            this.p[++this.topoPilha] = elemento; // Empilha o elemento e incrementa o índice do topo
        } else {
            System.out.println("Overflow - Estouro da pilha"); 
        }
    }

    public T pop() {
        if (!this.isEmpty()) {
            return this.p[this.topoPilha--]; // Retorna o elemento do topo e decrementa o índice
        } else {
            System.out.println("Underflow - Esvaziamento da pilha");
            return null;
        }
    }

    public T topo() {
        if (!this.isEmpty()) {
            return this.p[this.topoPilha]; // Retorna o elemento do topo
        } else {
            System.out.println("Underflow - Esvaziamento da pilha");
            return null;
        }
    }

    public int sizeElements() {
        return topoPilha + 1; // Retonrna a qtd de elementos na pilha
    }
}
