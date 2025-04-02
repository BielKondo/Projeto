import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Pilha p = new Pilha();
        Boolean onOff = true;
        Scanner sc = new Scanner(System.in);
        int contVar = 0;
        String[] numeros = new String[50];
        char[] variaveis = new char[50];
        //String variavel = sc.nextLine();

        int n1 = 0, n2 = 0;

        while (onOff) {
            String variavel = sc.nextLine();

            if (variavel.equals("/sair")) {
                onOff = false;
                break;
            }

            EntradaDados entrada = new EntradaDados(sc);
            





            
            // String[] numeros = entrada.getNumeros();
            // char[] variaveis = entrada.getVariaveis();
            // int contVar = entrada.getContVar();

            
            // String num = "";

            // variavel = variavel.toUpperCase();
            // variavel = variavel.replaceAll(" ", ""); // Remove espaços em branco

            // char[] variavelArray = variavel.toCharArray();
            // int tamVar = variavel.length();

            // if (tamVar <= 1) {
            //     if (Character.isLetter(variavelArray[0])) {
            //         if (contVar == 0) {
            //             System.out.println("Variavel nao encontrada.");
            //         }
            //         for (int k = 0; k < contVar; k++) {
            //             if (variavelArray[0] == variaveis[k]) {
            //                 System.out.println(numeros[k]);
            //                 break;
            //             }

            //             if (k == contVar - 1) {
            //                 System.out.println("Variavel nao encontrada.");
            //             }
            //         }
            //     }
            // }
            // else {
                //Se tamVar > 1
            // if (Character.isLetter(variavelArray[0]) && variavelArray[1] == '=') { //
            //     if (tamVar > 3) {
            //         for (int i = 2; i <= tamVar; i++) {
            //             if (Character.isDigit(variavelArray[i])) {
            //                 num += variavelArray[i];
            //                 if (i == tamVar - 1) { // Se verificar que os caracteres são números, ele conta como 1 variável válida
            //                     contVar += 1;
            //                 }
            //             } else {
            //                 System.out.println("Erro: expressão inválida");
            //             }
            //         }
            //         variaveis[contVar] = variavelArray[0];
            //         numeros[contVar] = num;
            //         num = "";
            //     } else {
            //         if (Character.isDigit(variavelArray[2])) {  //x=12, y=2 numeros =[12, \0]
            //             num = Character.toString(variavelArray[2]); // Transforma o caracter para string, pois a lista de números são strings
            //             variaveis[contVar] = variavelArray[0];
            //             numeros[contVar] = num;
            //             contVar++;
            //             num = "";
            //         } else {
            //             System.out.println("Erro: expressão inválida");
            //         }
                 }
            //} 
            // if (Character.isLetter(variavelArray[0])) {
            //     if (contVar == 0) {
            //         System.out.println("Variavel " + variavelArray[0] + " nao encontrada. 1");
            //     }
                
            //     for (int i = 0; i < contVar; i++) {
            //         if (variavelArray[0] == variaveis[i]) {
            //             break;
            //         }

            //         if (i == contVar - 1) {
            //             System.out.println("Variavel " + variavelArray[0] + " nao encontrada 2.");
            //         }
            //     }
                //Soma
        //         if (variavelArray[1] == '+' && Character.isLetter(variavelArray[2])) {
        //             for (int i = 0; i < contVar; i++) {
        //                 if (variavelArray[2] == variaveis[i]) {
        //                     break;
        //                 }

        //                 if (i == contVar - 1) {
        //                     System.out.println("Variavel " + variavelArray[0] + " nao encontrada 4.");
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[0] == variaveis[k]) {
        //                     n1 = Integer.valueOf(numeros[k]);
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[2] == variaveis[k]) {
        //                     n2 = Integer.valueOf(numeros[k]);
        //                 }
        //             }
        //             int soma = 0;
        //             soma = n1 + n2;
        //             System.out.println(soma);
        //         } 
        //         //Subtração
        //         else if (variavelArray[1] == '-' && Character.isLetter(variavelArray[2])) {
        //             for (int i = 0; i < contVar; i++) {
        //                 if (variavelArray[2] == variaveis[i]) {
        //                     break;
        //                 }

        //                 if (i == contVar - 1) {
        //                     System.out.println("Variavel " + variavelArray[0] + " nao encontrada 4.");
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[0] == variaveis[k]) {
        //                     n1 = Integer.valueOf(numeros[k]);
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[2] == variaveis[k]) {
        //                     n2 = Integer.valueOf(numeros[k]);
        //                 }
        //             }
        //             int sub = 0;
        //             sub = n1 - n2;
        //             System.out.println(sub);
        //         } 
        //         //Multiplicação
        //         else if (variavelArray[1] == '*' && Character.isLetter(variavelArray[2])) {
        //             for (int i = 0; i < contVar; i++) {
        //                 if (variavelArray[2] == variaveis[i]) {
        //                     break;
        //                 }

        //                 if (i == contVar - 1) {
        //                     System.out.println("Variavel " + variavelArray[0] + " nao encontrada 4.");
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[0] == variaveis[k]) {
        //                     n1 = Integer.valueOf(numeros[k]);
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[2] == variaveis[k]) {
        //                     n2 = Integer.valueOf(numeros[k]);
        //                 }
        //             }
        //             int mult = 0;
        //             mult = n1 * n2;
        //             System.out.println(mult);
        //         } 
        //         //Divisão
        //         else if (variavelArray[1] == '/' && Character.isLetter(variavelArray[2])) {
        //             for (int i = 0; i < contVar; i++) {
        //                 if (variavelArray[2] == variaveis[i]) {
        //                     break;
        //                 }

        //                 if (i == contVar - 1) {
        //                     System.out.println("Variavel " + variavelArray[0] + " nao encontrada 4.");
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[0] == variaveis[k]) {
        //                     n1 = Integer.valueOf(numeros[k]);
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[2] == variaveis[k]) {
        //                     n2 = Integer.valueOf(numeros[k]);
        //                 }
        //             }
        //             int div = 0;
        //             div = n1 / n2;
        //             System.out.println(div);
        //         } 

        //         else if (variavelArray[1] == '^' && Character.isLetter(variavelArray[2])) {
        //             for (int i = 0; i < contVar; i++) {
        //                 if (variavelArray[2] == variaveis[i]) {
        //                     break;
        //                 }

        //                 if (i == contVar - 1) {
        //                     System.out.println("Variavel " + variavelArray[0] + " nao encontrada 4.");
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[0] == variaveis[k]) {
        //                     n1 = Integer.valueOf(numeros[k]);
        //                 }
        //             }

        //             for (int k = 0; k < contVar; k++) {
        //                 if (variavelArray[2] == variaveis[k]) {
        //                     n2 = Integer.valueOf(numeros[k]);
        //                 }
        //             }
        //             int exp = 0;
        //             exp = n1 ^ n2;
        //             System.out.println(exp);
        //         } else {
        //         System.out.println("Erro: expressão inválida");
        //     }
        // }
            

            // for (int j=0; j < contVar; j++) {
            //     System.out.println("Variável: " + variaveis[j] + " " + "Num: " + numeros[j]);    
            // }
        
        //}
    //}
    }

        //p.EXIT();
    //}
    //
//}

}




 