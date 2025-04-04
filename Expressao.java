public class Expressao {

    public void lerExpressao(String variavel, int contVar, char[] variaveis, String[] numeros) {
        StringBuilder sb = new StringBuilder();
        variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco

        char[] expressaoArray = variavel.toCharArray();

        int tamExp = variavel.length(), parenteses = 0, parenteses1 = 0;

        Pilha pilha = new Pilha();

        for (int i = 0; i < tamExp; i++) { // Percorre a expressao
            if (Character.isLetter(expressaoArray[i])) { // Se for uma letra Ex: A + (B - C) * D
                if (contVar == 0) { // Se nao existir nenhuma variavel declarada
                    System.out.println("Erro: variável " + expressaoArray[i] + " nao definida"); // Se não houver variaveis, imprime erro
                } else {
                    for (int j = 0; j < contVar; j++) { // Percorre a qtd de variaveis totais
                        if (expressaoArray[i] == variaveis[j]) { // Se encontrar a mesma letra em variaveis[j], significa que ela ja foi declarada com seu valor
                            sb.append(expressaoArray[i]); // Adiciona a variavel ao StringBuilder
                            //break; // Sai do 'for' se encontrar a variavel

                            break;
                        }
                        
                        if (j == contVar - 1) { // Se terminar o 'for', não foi encontrada a variavel
                            //System.out.println("J: " + j + " contVar: " + contVar);
                            System.out.println("Erro: variável " + expressaoArray[i] + " nao definida 1");
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
                } else {
                    System.out.println("Erro: Parêntese de fechamento sem correspondente.");
                }
            } else { // Se for operacao 
                while (!pilha.isEmpty() && Prioridade.prioridade(expressaoArray[i]) <= Prioridade.prioridade((char) pilha.topo())) {
                    sb.append(pilha.pop()); // ABC-D*+                      2       <=    1
                }
                pilha.push(expressaoArray[i]); // Empilha o operador atual 
            }
        }

        if (parenteses != parenteses1) {
            System.out.println("Erro: expressao invalida.");
        }

        while (!pilha.isEmpty()) {
            sb.append(pilha.pop());
        }

        // if (parenteses == parenteses1) { // Se for o último caractere da expressão
        //     for (int i = 0; i < tamExp; i++) { // Percorre a expressao novamente
        //         if (Character.isLetter(expressaoArray[i])) {
        //             for (int k = 0; k < contVar; k++) {
        //                 if (expressaoArray[i] == variaveis[k]) { // Se encontrar a mesma letra em variaveis[k]
        //                     if (i == tamExp - 1 || expressaoArray[i] == ')') { // Se for o último caractere da expressão
        //                         System.out.println(sb.toString());
                            
        //                     }
        //                 }
        //             }
        //         }      
        //     }
        // }

        System.out.println(sb.toString());
    }
}