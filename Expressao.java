import javax.swing.plaf.synth.SynthScrollBarUI;

public class Expressao {

    public void lerExpressao(String variavel, int contVar, char[] variaveis, double[] numeros) {
        Comandos comando = new Comandos();
        Fila fila = new Fila();
        StringBuilder sb = new StringBuilder();
        variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco

        char[] expressaoArray = variavel.toCharArray();

        int tamExp = variavel.length(), parenteses = 0, parenteses1 = 0, letras = 0;

        Pilha<Character> pilha = new Pilha<>();

        // if (Character.isLetter(expressaoArray[0]) && Character.isLetter(expressaoArray[1])) {
        //     comando.comando(variavel);
        // }

        for (int i = 0; i < tamExp; i++) {
            if (expressaoArray[i] == '(') {
                parenteses++;
            } else if (expressaoArray[i] == ')') {
                parenteses1++;
            }
        }

        if ((Character.isLetter(expressaoArray[0]) && !Character.isLetter(expressaoArray[1])) || (!Character.isLetter(expressaoArray[0]) && Character.isLetter(expressaoArray[1]))) {
        for (int i = 0; i < tamExp; i++) { // Percorre a expressao A+(B-C)

            if (Character.isLetter(expressaoArray[i])) { // Se for uma letra Ex: A + (B - C) * D
                letras++;
                if (contVar == 0) { // Se nao existir nenhuma variavel declarada
                    System.out.println("Erro: variável " + expressaoArray[i] + " nao definida 1"); // Se não houver variaveis, imprime erro
                } else { 
                    if (parenteses != parenteses1) {
                        System.out.println("Erro: expressao invalida.");
                        break;
                    }

                    for (int j = 0; j < contVar; j++) { // Percorre a qtd de variaveis totais
                        if (expressaoArray[i] == variaveis[j]) { // Se encontrar a mesma letra em variaveis[j], significa que ela ja foi declarada com seu valor
                            sb.append(expressaoArray[i]); // Adiciona a variavel ao StringBuilder
                            letras--;
                            break;
                        } else if (j == contVar - 1) { // Se terminar o 'for', não foi encontrada a variavel
                            //System.out.println("J: " + j + " contVar: " + contVar);
                            System.out.println("Erro: variável " + expressaoArray[i] + " nao definida.");
                            break;
                        }
                    }
                }

            //sb.append(expressaoArray[i]); // ABC-+
                
            } else if (expressaoArray[i] == '(') {
                pilha.push(expressaoArray[i]); // Push '(' para a pilha ['(', -]
            } else if (expressaoArray[i] == ')') { // A + (B - C) * D

                while (!pilha.isEmpty() && (char) pilha.topo() != '(') {
                    //System.out.println("Pilha: " + pilha.pop());
                    sb.append(pilha.pop());
                }
                if (!pilha.isEmpty() && (char) pilha.topo() == '(') {
                    pilha.pop(); // Remove o parêntese de abertura da pilha
                }
            } else { // Se for operacao 
                while (!pilha.isEmpty() && Prioridade.prioridade(expressaoArray[i]) <= Prioridade.prioridade((char) pilha.topo())) {
                    sb.append(pilha.pop()); // ABC-D*+                      2       <=    1
                }
                pilha.push(expressaoArray[i]); // Empilha o operador atual 
            }
        }

        while (!pilha.isEmpty()) {
            sb.append(pilha.pop()).append(" ");
            if (pilha.isEmpty() && letras == 0) {
                int tamSb = sb.length(); // Declare and initialize tamSb here
                System.out.println(sb.toString());
                fila.fila(tamSb, sb.toString(), contVar, variaveis, numeros); // Envia a expressao para a fila
                sb.setLength(0); // Limpa o StringBuilder para a próxima expressão (Fonte: AI)
            }
        }

    } else {
        comando.comando(variavel);

        if (!variavel.equals("REC") && !variavel.equals("STOP") && !variavel.equals("PLAY") && !variavel.equals("ERASE") && 
        !variavel.equals("VARS") && !variavel.equals("RESET")) {
            System.out.println("Erro: expressao invalida.");
        }
            
        }
    }
}
