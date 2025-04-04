import java.util.Scanner;

public class EntradaDados {
    int contVar = 0;
    double[] numeros = new double[50];
    char[] variaveis = new char[50];
    char[] pilhaExp = new char[50];
    char[] pilhaExpAux = new char[50];

    public void entradaDados(Scanner sc) {  // Funcao para ler o que o usuario digita
        Expressao expressao = new Expressao(); // Inicializa a classe Expressao
        String variavel = sc.nextLine();

        variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco
        variavel = variavel.toUpperCase(); // Transforma os caracteres de variavel em maiúsculo

        String num = ""; // Inicializa a string num vazia para armazenar o valor da variavel

        char[] variavelArray = variavel.toCharArray(); // Tranforma a string variavel em um array de caracteres
        int tamVar = variavel.length(); // Calcula o tamanho da variavel

        if (tamVar == 1) { // Se tamVar == 1, significa que o usuário digitou apenas uma letra
            if (Character.isLetter(variavelArray[0])) { // Se o primeiro caractere for uma letra
                if (contVar == 0) { // Se não existir nenhuma variável declarada
                    System.out.println("Variavel " + variavelArray[0] + " nao encontrada.");
                }
                for (int k = 0; k < contVar; k++) { // Percorre a qtd de variaveis totais
                    if (variavelArray[0] == variaveis[k]) { // Se o caractere for encontrado na lista de variaveis                        System.out.println(numeros[k]);
                        break; // para
                    }

                    if (k == contVar - 1) { // Se terminar o 'for', não foi encontrada a variavel
                        System.out.println("Variavel " + variavelArray[0] + " nao encontrada.");
                    }
                }
            }
        } else if (tamVar == 0) { // Se tamVar == 0, significa que o usuário não digitou nada
            System.out.println("Digite um comando válido.");
        } else { // Se tamVar > 1
            if (Character.isLetter(variavelArray[0]) && variavelArray[1] == '=') { // Ex: 'x'=
                if (tamVar > 3) { // Se tamVar maior que 3, o número tem mais de 1 dígito
                    for (int i = 2; i < tamVar; i++) {  // 'for' para ler o número com mais de 1 dígito
                        if (Character.isDigit(variavelArray[i]) || variavelArray[i] == '.') { // Se for um dígito
                            num += variavelArray[i]; // Adiciona o caractere a string num
                            if (i == tamVar - 1) { // Quando terminar de ler os números
                                contVar += 1; // Adiciona +1 ao contVar
                            }
                        } else { // Se o caractere não for um dígito
                            System.out.println("Erro: expressao invalida.");
                            //return;
                        }
                    }
                    variaveis[contVar] = variavelArray[0]; // Armazena a variável
                    numeros[contVar] = Double.parseDouble(num); // Converte para double e armazena o número
                    num = ""; // Reseta a string num para o próximo número
                } else if (tamVar == 3) { // Se tamVar for igual a 3, o número tem apenas 1 dígito
                    if (Character.isDigit(variavelArray[2])) { // Se o terceiro caractere for um dígito
                        num = Character.toString(variavelArray[2]); // Transforma o dígito para string, pois o array de numeros é do tipo string
                        variaveis[contVar] = variavelArray[0]; // Armazena a variável
                        numeros[contVar] = Double.parseDouble(num); // Converte para double e armazena
                        contVar++; // Adiciona +1 ao contVar para armazenar na próxima posição
                        num = ""; // Reinicia a string num para o próximo número
                    } else {
                        System.out.println("Erro: expressao invalida.");
                    }
                } else {
                    System.out.println("Erro: expressao invalida.");
                }
            } else { // Se o Caractere1 e o Caractere2 não forem iguais a 'Letra' e '=', respectivamente
                expressao.lerExpressao(variavel, contVar, variaveis, numeros); // Chama a funcao lerExpressao da classe Expressao
            }
        }
    }
}