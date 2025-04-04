// filepath: c:\Users\gabri\OneDrive\Área de Trabalho\Random\Projeto\Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean onOff = true;

        Scanner sc = new Scanner(System.in); // Criação de um único Scanner
        EntradaDados entrada = new EntradaDados(); // Passa o Scanner para a classe

        while (onOff) {
            entrada.entradaDados(sc);
        }
    }
}