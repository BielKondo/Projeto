public class Prioridade {
    public static int prioridade(char operacao) {
        switch (operacao) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0; // Operandos e parênteses têm precedência 0
                }
    }
}
