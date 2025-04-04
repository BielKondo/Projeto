public class Comandos {
    public void comando(String variavel){
    //try (Scanner scanner = new Scanner(System.in)) {
        String[] comandosGravados = new String[10]; //limite de 10 Comandos
        
        int numComandosGravados = 0;

        boolean gravando = false;

        //while (true){
            //String comando = scanner.nextLine();

            if (variavel.equals("REC")){
                if (!gravando){
                    gravando = true;
                    numComandosGravados = 0;
                    System.out.println("Iniciando gravação... (REC: 0/10)"); 
                } else {
                    System.out.println("Erro: Gravação ja iniciada.");
                }

            } else if (variavel.equals("STOP")){
                if (gravando){
                    gravando = false;
                    System.out.println("Encerrando gravação... (REC: " + numComandosGravados + "/10)");
                } else {
                    System.out.println("Erro: Nenhuma gravação em andamento.");
                }

            } else if (variavel.equals("PLAY")){
                if (!gravando){
                    if (numComandosGravados > 0){
                        System.out.println("Reproduzindo gravação...");
                        //executarComandos
                    } else {
                        System.out.println("Não há gravação para ser reproduzida.");
                    }
                }

            } else if (variavel.equals("ERASE")){
                if (!gravando){
                    numComandosGravados = 0;
                    System.out.println("Gravação apagada.");
                } else {
                    System.out.println("Erro: Comando inválido durante a gravação.");
                }

            } else if (gravando) {
                if (numComandosGravados < comandosGravados.length) {
                    comandosGravados[numComandosGravados] = variavel;
                    numComandosGravados++;
                    System.out.println("(REC: " + numComandosGravados + "/10) " + variavel);
                } else {
                    System.out.println("Erro: Limite de comandos atingido.");
                }
            
            } else if (variavel.equals("EXIT")) {
                System.exit(0);
            }
        //}
    }
}
//}