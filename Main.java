// filepath: c:\Users\gabri\OneDrive\Área de Trabalho\Random\Projeto\Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean onOff = true;

        EntradaDados entrada = new EntradaDados();
        Expressao expressao = new Expressao();

        while (onOff) {
            entrada.entradaDados(sc);

        }
    }
}