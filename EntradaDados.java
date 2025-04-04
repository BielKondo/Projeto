import java.util.Scanner;

public class EntradaDados {
    int contVar = 0, index = 0, index1 = 0;
    double[] numeros = new double[50]; // Alterado para double[]
    char[] variaveis = new char[50];
    char[] pilhaExp = new char[50];
    char[] pilhaExpAux = new char[50];

    public void entradaDados(Scanner sc) {
        Expressao expressao = new Expressao();
        String variavel = sc.nextLine();

        variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco
        variavel = variavel.toUpperCase();

        String num = "";

        char[] variavelArray = variavel.toCharArray();
        int tamVar = variavel.length();

        if (tamVar == 1) {
            if (Character.isLetter(variavelArray[0])) {
                if (contVar == 0) {
                    System.out.println("Variavel " + variavelArray[0] + " nao encontrada.");
                }
                for (int k = 0; k < contVar; k++) {
                    if (variavelArray[0] == variaveis[k]) {
                        System.out.println(numeros[k]);
                        break;
                    }

                    if (k == contVar - 1) {
                        System.out.println("Variavel " + variavelArray[0] + " nao encontrada.");
                    }
                }
            }
        } else if (tamVar == 0) {
            System.out.println("Digite um comando válido.");
        } else { // Se tamVar > 1
            if (Character.isLetter(variavelArray[0]) && variavelArray[1] == '=') { // Ex: 'x'=
                if (tamVar > 3) { // Se tamVar maior que 3, o número tem mais de 1 dígito
                    for (int i = 2; i < tamVar; i++) {  // 'for' para ler o número
                        if (Character.isDigit(variavelArray[i]) || variavelArray[i] == '.') { // Se for um dígito ou ponto decimal
                            num += variavelArray[i]; // Adiciona o caractere à String num
                            if (i == tamVar - 1) { // Quando terminar de ler os números
                                contVar += 1; // Adiciona +1 ao contVar
                            }
                        } else { // Se o caractere não for um dígito ou ponto decimal
                            System.out.println("Erro: expressao invalida 4");
                            return;
                        }
                    }
                    variaveis[contVar] = variavelArray[0]; // Armazena a variável
                    numeros[contVar] = Double.parseDouble(num); // Converte para double e armazena o número
                    num = ""; // Reseta a string num para o próximo número
                } else if (tamVar == 3) { // Se tamVar for igual a 3, o número tem apenas 1 dígito
                    if (Character.isDigit(variavelArray[2])) { // Se o terceiro caractere for um dígito
                        num = Character.toString(variavelArray[2]); // Transforma o dígito para string
                        variaveis[contVar] = variavelArray[0];
                        numeros[contVar] = Double.parseDouble(num); // Converte para double e armazena
                        contVar++;
                        num = "";
                    } else {
                        System.out.println("Erro: expressao invalida 3");
                    }
                } else {
                    System.out.println("Erro: expressao invalida 2");
                }
            } else {
                expressao.lerExpressao(variavel, contVar, variaveis, numeros);
            }
        }
    }
}