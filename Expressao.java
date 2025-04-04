public class Expressao {

    public void lerExpressao(String variavel, int contVar, char[] variaveis, String[] numeros) {
        Comandos comando = new Comandos();
        StringBuilder sb = new StringBuilder();
        variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco

        char[] expressaoArray = variavel.toCharArray();

        int tamExp = variavel.length(), parenteses = 0, parenteses1 = 0, letras = 0;

        Pilha pilha = new Pilha();

        if (Character.isLetter(expressaoArray[0]) && Character.isLetter(expressaoArray[1])) {
            comando.comando(variavel);
        }

        if (Character.isLetter(expressaoArray[0]) && !Character.isLetter(expressaoArray[1])) {
        for (int i = 0; i < tamExp; i++) { // Percorre a expressao
            //if (Character.isLetter(expressaoArray[0]) && !Character.isLetter(expressaoArray[1])) 
            // if (parenteses != parenteses1) {
            //     System.out.println("Erro: expressao invalida.");
            //     break;
            // }

            if (Character.isLetter(expressaoArray[i])) { // Se for uma letra Ex: A + (B - C) * D
                letras++;
                if (contVar == 0) { // Se nao existir nenhuma variavel declarada
                    System.out.println("Erro: variável " + expressaoArray[i] + " nao definida 1"); // Se não houver variaveis, imprime erro
                } else {
                    for (int j = 0; j < contVar; j++) { // Percorre a qtd de variaveis totais
                        if (expressaoArray[i] == variaveis[j]) { // Se encontrar a mesma letra em variaveis[j], significa que ela ja foi declarada com seu valor
                            sb.append(expressaoArray[i]); // Adiciona a variavel ao StringBuilder
                            //break; // Sai do 'for' se encontrar a variavel
                            if (i == letras) {
                                System.out.println(sb.toString());
                            }
                        } else if (j == contVar - 1) { // Se terminar o 'for', não foi encontrada a variavel
                            //System.out.println("J: " + j + " contVar: " + contVar);
                            System.out.println("Erro: variável " + expressaoArray[i] + " nao definida 2");
                            break;
                        }
                    }
                }

            //sb.append(expressaoArray[i]); // ABC-+
                
            } else if (expressaoArray[i] == '(') {
                parenteses += 1;
                pilha.push(expressaoArray[i]); // Push '(' para a pilha ['(', -]
                ;
            } else if (expressaoArray[i] == ')') { // A + (B - C) * D
                parenteses1 += 1;
                while (!pilha.isEmpty() && pilha.topo() != '(') {
                    //System.out.println("Pilha: " + pilha.pop());
                    sb.append(pilha.pop());
                }
                if (!pilha.isEmpty() && pilha.topo() == '(') {
                    pilha.pop(); // Remove o parêntese de abertura da pilha
                }
            } else { // Se for operacao 
                while (!pilha.isEmpty() && Prioridade.prioridade(expressaoArray[i]) <= Prioridade.prioridade((char) pilha.topo())) {
                    sb.append(pilha.pop()); // ABC-D*+                      2       <=    1
                }
                pilha.push(expressaoArray[i]); // Empilha o operador atual 
            }
        }
    }

        if (parenteses != parenteses1) {
            System.out.println("Erro: expressao invalida.");
        }

        while (!pilha.isEmpty()) {
            sb.append(pilha.pop());
        }
    }
}
