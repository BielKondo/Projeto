public class Pilha {
    private int topoPilha;
    private int p[ ];
    private static int tam_padrao = 100;

    public Pilha(int tamanho) {
        this.p = new int [tamanho];
        this.topoPilha = -1;
        }
        public Pilha() {
            this(tam_padrao);
        }

        public boolean isEmpty() {
            if (this.topoPilha == -1)
                return true;
            else
                return false;
        }
            
        public boolean isFull() {
            if (this.topoPilha == this.p.length - 1)
                return true;
            else
                return false;
        }
        
        public void push(int p) {
            if (!this.isFull()) {
                this.p[++this.topoPilha] = p;
            } else {
                System.out.println("Overflow - Estouro da pilha");
            }
                
        }

        public int pop() {
            if (!this.isEmpty( )) {
                return this.p[this.topoPilha--];
            } else {
                System.out.println("Underflow - Esvaziamento da pilha");
            }
            return topoPilha;
        }

        public int topo() {
            if (!this.isEmpty( )) {
                return this.p[this.topoPilha];
            } else {
                System.out.println("Underflow - Esvaziamento da pilha");
            }
            return topoPilha;
        }

        public int sizeElements() {
            return topoPilha + 1;
        }

    }