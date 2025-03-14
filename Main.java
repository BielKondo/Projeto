import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Pilha p = new Pilha();
        Boolean onOff = true;
        Scanner sc = new Scanner(System.in);
        int contVar = 0;

        while (onOff) {
            String variavel = sc.nextLine();
            String num = "";

            variavel = variavel.toUpperCase();

            char[] variavelArray = variavel.toCharArray();
            int tamVar = variavel.length();

            //System.out.println("Tamanho da variável: " + tamVar);


            if (Character.isLetter(variavelArray[0]) && variavelArray[1] == ' ' && variavelArray[2] == '=' && variavelArray[3] == ' ') {
                if (tamVar > 5) {
                    for (int i = 4; i <= tamVar; i++) {
                        if (Character.isDigit(variavelArray[i])) {
                            num += variavelArray[i];
                        } else {
                            System.out.println("Erro: expressão inválida");
                        }
                    }
                } else {
                    if (Character.isDigit(variavelArray[4])) {
                        num += variavelArray[4];
                    } else {
                        System.out.println("Erro: expressão inválida");
                }

                contVar += 1;
                int tamVariaveis = (contVar*2);
                //System.out.println("Tamanho variáveis: " + tamVariaveis);
                String variaveis[] = new String[(tamVariaveis)]; // Lista para armazenar as variáveis e seus valores
                System.out.println("Tamanho da lista: " + tamVariaveis);
                int numero = Integer.valueOf(num); // Transforma a string num em um número inteiro
                        //System.out.println("Variável: " + variavelArray[0] + " = " + "Número: " + numero); 
                    for (int j = 0; j < (tamVariaveis); j++) {
                            //System.out.println("J: " + j);
                            variaveis[j] = String.valueOf(variavelArray[0]); // É necessário transformar o caractere em string para poder armazenar a variável
                            variaveis[j+1] = String.valueOf(numero); // É necessário transformar o número em string para poder armazenar o número
                            //System.out.println(j);
                            j++;
                            //System.out.println(j);
                            if (variavelArray[0] == variavelArray[j]) {
                                variavelArray[j + 1] = variavelArray[numero];
                            }
                            //System.out.println("Variável: " + variaveis[j] + " Número: " + variaveis[j+1]);
                        }

                        for (int k = 0; k < (contVar - 1); k++) {
                            System.out.println("Variável: " + variaveis[k] + " Número: " + variaveis[k+1]);
                            k++;
                        }
                        //variavel = sc.nextLine();
                    //} else {
                        //System.out.println("Erro: expressão inválida");
                    }
                }
            //} else {
                //System.out.println("Erro: expressão inválida");
                //variavel = sc.nextLine();
            //}
        }
        // while (contVar <= 1) {
        //     Scanner sc = new Scanner(System.in);
        //     contVar += 1;
        // }
        // for (int i = 0; i < tamVar; i++) {
        //     if (Character.isLetter(variavelArray[i])) {
        //         variavelArray[i] = Character.toUpperCase(variavelArray[i]);
        //         System.out.println("Caractere: " + variavelArray[i]);
        //     } else if (Character.isDigit(variavelArray[i])) {
        //         variavelArray[i] = Character.forDigit(Character.getNumericValue(variavelArray[i]), 10);
        //         //variavelArray[i] = Character.getNumericValue(variavelArray[i]);
        //         //System.out.println("Dígito: " + variavelArray[i]);
        //     }
        //     System.out.println("variavelArray[i]: " + variavelArray[i]);
        // }

        // System.out.println(variavelArray);

        //p.EXIT();
    //}
    }
}




 