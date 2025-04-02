import java.util.Scanner;

public class Pilha {
    public static void main(String[] args){
    try (Scanner scanner = new Scanner(System.in)) {
        String[] comandosGravados = new String[10]; //limite de 10 Comandos
        
        int numComandosGravados = 0;

        boolean gravando = false;

        while (true){
            String comando = scanner.nextLine();

            if (comando.equals("REC")){
                if (!gravando){
                    gravando = true;
                    numComandosGravados = 0;
                    System.out.println("Iniciando gravação... (REC: 0/10)"); 
                } else {
                    System.out.println("Erro: Gravação ja iniciada.");
                }

            } else if (comando.equals("STOP")){
                if (gravando){
                    gravando = false;
                    System.out.println("Encerrando gravação... (REC: " + numComandosGravados + "/10)");
                } else {
                    System.out.println("Erro: Nenhuma gravação em andamento.");
                }

            } else if (comando.equals("PLAY")){
                if (!gravando){
                    if (numComandosGravados > 0){
                        System.out.println("Reproduzindo gravação...");
                        //executarComandos
                    } else {
                        System.out.println("Não há gravação para ser reproduzida.");
                    }
                }

            } else if (comando.equals("ERASE")){
                if (!gravando){
                    numComandosGravados = 0;
                    System.out.println("Gravação apagada.");
                } else {
                    System.out.println("Erro: Comando inválido durante a gravação.");
                }

            } else if (gravando) {
                if (numComandosGravados < comandosGravados.length) {
                    comandosGravados[numComandosGravados] = comando;
                    numComandosGravados++;
                    System.out.println("(REC: " + numComandosGravados + "/10) " + comando);
                } else {
                    System.out.println("Erro: Limite de comandos atingido.");
                }
            
            } else if (comando.equals("EXIT")) {
                System.exit(0);
            }
        }
    }
    }
}