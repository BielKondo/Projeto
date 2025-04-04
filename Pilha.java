public class Pilha {
    private int topoPilha; // Índice do topo da pilha
    private char[] p; // Array para armazenar caracteres
    private static int tam_padrao = 100; // Tamanho padrão da pilha

    // Construtor com tamanho personalizado
    public Pilha(int tamanho) {
        this.p = new char[tamanho]; // Aloca o array para caracteres
        this.topoPilha = -1; // Inicializa o topo como vazio
    }

    // Construtor com tamanho padrão
    public Pilha() {
        this(tam_padrao);
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return this.topoPilha == -1;
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return this.topoPilha == this.p.length - 1;
    }

    // Empilha um caractere
    public void push(char elemento) {
        if (!this.isFull()) {
            this.p[++this.topoPilha] = elemento; // Adiciona o elemento no topo
        } else {
            System.out.println("Overflow - Estouro da pilha");
        }
    }

    // Desempilha um caractere
    public char pop() {
        if (!this.isEmpty()) {
            return this.p[this.topoPilha--]; // Retorna o elemento do topo e decrementa o índice
        } else {
            System.out.println("Underflow - Esvaziamento da pilha");
            return '\0'; // Retorna um caractere nulo em caso de erro
        }
    }

    // Retorna o elemento no topo da pilha sem removê-lo
    public char topo() {
        if (!this.isEmpty()) {
            return this.p[this.topoPilha]; // Retorna o elemento do topo
        } else {
            System.out.println("Underflow - Esvaziamento da pilha");
            return '\0'; // Retorna um caractere nulo em caso de erro
        }
    }

    // Retorna o número de elementos na pilha
    public int sizeElements() {
        return topoPilha + 1;
    }
}