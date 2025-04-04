public class Expressao {

    public void lerExpressao(String variavel, int contVar, char[] variaveis, double[] numeros) {
        Comandos comando = new Comandos(); // Inicializa a classe Comandos
        //Fila fila = new Fila();
        StringBuilder sb = new StringBuilder(); // StringBuilder para armazenar as letras
        variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco

        char[] expressaoArray = variavel.toCharArray();
        

        int tamExp = variavel.length(), parenteses = 0, parenteses1 = 0, letras = 0;

        Pilha<Character> pilha = new Pilha<>();
        Pilha<Integer> pilha2 = new Pilha<>();


        for (int i = 0; i < tamExp; i++) { // Percorre a expressao e conta os parenteses
            if (expressaoArray[i] == '(') {
                parenteses++;
            } else if (expressaoArray[i] == ')') {
                parenteses1++;
            }
        }


        if ((Character.isLetter(expressaoArray[0]) && !Character.isLetter(expressaoArray[1])) || (!Character.isLetter(expressaoArray[0]) && Character.isLetter(expressaoArray[1]))) {
        for (int i = 0; i < tamExp; i++) { // Se o Caractere1 for letra e o Caractere2 for operador, ou vice-versa, tomamos como conclusao que é uma expressao

            if (Character.isLetter(expressaoArray[i])) { // Se for uma letra Ex: A + (B - C) * D
                letras++;
                if (contVar == 0) { // Se nao existir nenhuma variavel declarada
                    System.out.println("Erro: variável " + expressaoArray[i] + " nao definida."); // Se não houver variaveis, imprime erro
                } else { 
                    if (parenteses != parenteses1) {
                        System.out.println("Erro: expressao invalida.");
                        break;
                    }

                    for (int j = 0; j < contVar; j++) { // Percorre a qtd de variaveis totais
                        if (expressaoArray[i] == variaveis[j]) { // Se encontrar a mesma letra em variaveis[j], significa que ela ja foi declarada com seu valor
                            sb.append(expressaoArray[i]); // Adiciona a variavel ao StringBuilder
                            pilha2.push(j); // Adiciona o índice da variável na pilha2
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
                
            } else if (expressaoArray[i] == '(') { // Se achar o '('
                pilha.push(expressaoArray[i]); // Push '(' para a pilha ['(']
            } else if (expressaoArray[i] == ')') { // Se achar o ')'

                while (!pilha.isEmpty() && (char) pilha.topo() != '(') { // Se a pilha não estiver vazia e o topo não for '('
                    sb.append(pilha.pop()); // Adiciona o operador ao StringBuilder
                }
                if (!pilha.isEmpty() && (char) pilha.topo() == '(') { // Se o topo for '('
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
                //int tamSb = sb.length(); 
                
                System.out.println(sb.toString());

                for (int m = 0; m < tamExp; m++) {
                    if (expressaoArray[m] == '+') {
                        double soma = numeros[m-1] + numeros[m]; 
                        System.out.println(soma);
                    } else if (expressaoArray[m] == '-') {
                        double sub = numeros[m-1] - numeros[m]; 
                        System.out.println(sub);
                    } else if (expressaoArray[m] == '*') {
                        double multiplicacao = numeros[0] * numeros[1];
                        System.out.println(multiplicacao);
                    } else if(expressaoArray[m] == '/') {
                        double div = numeros[0] / numeros[1];
                        System.out.println(div);
                    } else if (expressaoArray[m] == '^') {
                        double potencia = (int) Math.pow(numeros[m-1], numeros[m]);
                        System.out.println(potencia);
                    }




                }
                if (expressaoArray[1] == '+') {
                    double soma = numeros[0] + numeros[1];
                    System.out.println(soma);
                } else if (expressaoArray[1] == '-') {
                    double subtracao = numeros[0] + numeros[1];
                    System.out.println(subtracao);
                } else if (expressaoArray[1] == '*') {
                    double multiplicacao = numeros[0] + numeros[1];
                    System.out.println(multiplicacao);
                } else if (expressaoArray[1] == '/') {
                    double divisao = numeros[0] + numeros[1];
                    System.out.println(divisao);
                } else if (expressaoArray[1] == '^') {
                    double potencia = (int) Math.pow(numeros[0], numeros[1]);
                    System.out.println(potencia);
                }

                //fila.fila(tamSb, sb.toString(), contVar, variaveis, numeros); // Envia a expressao para a fila
                sb.setLength(0); // Limpa o StringBuilder para a próxima expressão (Fonte: AI)
            }
        }

    } else {
        comando.comando(variavel, variaveis, numeros, contVar);

        if (!variavel.equals("REC") && !variavel.equals("STOP") && !variavel.equals("PLAY") && !variavel.equals("ERASE") && 
        !variavel.equals("VARS") && !variavel.equals("RESET")) {
            System.out.println("Erro: expressao invalida.");
        }
            
        }
    }
}