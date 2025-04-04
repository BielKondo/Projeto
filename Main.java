//Eduardo Kenji Hernandes Ikematu 10439924
//Gabriel Hideaquy Kono 10436238
//João Pedro Sinzato Bocchini 10440034
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