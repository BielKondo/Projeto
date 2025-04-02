import java.util.Scanner;

public class EntradaDados {
    //Scanner sc = new Scanner(System.in);
    int contVar = 0;
    String[] numeros = new String[50];
    char[] variaveis = new char[50];

    public EntradaDados(Scanner sc) {
        String variavel = sc.nextLine();
        String num = "";

        variavel = variavel.toUpperCase();
        variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco

        char[] variavelArray = variavel.toCharArray();
        int tamVar = variavel.length();

        // Se tamVar for igual a 1
        if (tamVar == 1) {
            if (Character.isLetter(variavelArray[0])) {
                if (contVar == 0) { // Se contVar for igual a 0, não existe variáveis armazenadas ainda
                    System.out.println("Variavel " + variavelArray[0] + " nao encontrada. 1");
                }
                
                for (int i = 0; i < contVar; i++) {
                    if (variavelArray[0] == variaveis[i]) { // Se encontrar a variável na lista -> break
                        break;
                    }
    
                    if (i == contVar - 1) { // Se terminar a lista e não achar a variável
                        System.out.println("Variavel " + variavelArray[0] + " nao encontrada 2.");
                    }
                }

                for (int k = 0; k < contVar; k++) {
                    if (variavelArray[0] == variaveis[k]) { // Se encontrar a variável
                        System.out.println(numeros[k]); // Printa o valor da variável
                        break;
                    }
                }
            }
        
        } else if (tamVar < 1) { // Se tamVar for menor que 1
            System.out.println("Digite um comando válido.");
            variavel = sc.nextLine(); // Pede pro usuário digitar novamente

        } else { // Se tamVar for maior que 1
            if (Character.isLetter(variavelArray[0]) && variavelArray[1] == '=') { // Verifica se o primeiro caracter é igual a uma letra e se o segundo caracter é igual ao '='
                if (tamVar > 3) { // Se tamVar for maior que 3, significa que o valor da variável tem mais de 1 dígito
                    for (int i = 2; i <= tamVar; i++) { // For para ler o número com mais de 1 dígito
                        if (Character.isDigit(variavelArray[i])) { // Se verificar que os caracteres são números, ele adiciona o dígito a uma string
                            num += variavelArray[i];
                            if (i == tamVar - 1) { // Se o 'for' terminar, conta +1 para contVar
                                contVar += 1;
                            }
                        } else {
                            System.out.println("Erro: expressão inválida");
                        }
                    }
                    variaveis[contVar] = variavelArray[0]; // contVar começa no 1k
                    numeros[contVar] = num;
                    num = ""; // Reseta a string para armazenar o próximo número

                } else if (tamVar == 3) { // Se tamVar for igual a 3, significa que o número tem apenas um dígito
                    if (Character.isDigit(variavelArray[2])) {  // Se o terceiro caractere for um número
                        num = Character.toString(variavelArray[2]); // Transforma o caracter para string, pois a lista de números são strings
                        variaveis[contVar] = variavelArray[0]; // Armazena a variável
                        System.out.println("Variavel: " + variaveis[contVar]);
                        numeros[contVar] = num; // Armazena o número
                        System.out.println("Valor: " + numeros[contVar]);
                        contVar++; // Conta +1 para o contVar
                        num = ""; // Reseta a string para armazenar o próximo número
                    } else {
                        System.out.println("Erro: expressão inválida");
                    }

                } else {
                    System.out.println("Erro: expressao invalida.");
                }
            } else {
                System.out.println("Erro: expressão inválida");
            }
        }
    }



    public String[] getNumeros() {
        return numeros;
    }

    public char[] getVariaveis() {
        return variaveis;
    }

    public int getContVar() {
        return contVar;
    }
}
