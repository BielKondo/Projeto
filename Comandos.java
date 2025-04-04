public class Comandos {
    private String[] comandosGravados = new String[10];
    private int numComandosGravados = 0;
    private boolean gravando = false;
    private String[] nomesVariaveis = new String[26]; // A-Z
    private double[] valoresVariaveis = new double[26];
    private int numVariaveisDefinidas = 0;

    public Comandos() {
        // Inicializa o array de nomes de variáveis
        for (int i = 0; i < nomesVariaveis.length; i++) {
            nomesVariaveis[i] = null; // Indica que a variável não está definida
        }
    }

    public void comando(String variavel) {
        if (variavel.equals("REC")) {
            if (!gravando) {
                gravando = true;
                numComandosGravados = 0;
                System.out.println("Iniciando gravação... (REC: 0/10)");
            } else {
                System.out.println("Erro: Gravação já iniciada.");
            }
        } else if (variavel.equals("STOP")) {
            if (gravando) {
                gravando = false;
                System.out.println("Encerrando gravação... (REC: " + numComandosGravados + "/10)");
            } else {
                System.out.println("Erro: Nenhuma gravação em andamento.");
            }
        } else if (variavel.equals("PLAY")) {
            if (!gravando) {
                if (numComandosGravados > 0) {
                    System.out.println("Reproduzindo gravação...");
                    executarComandos();
                } else {
                    System.out.println("Não há gravação para ser reproduzida.");
                }
            }
        } else if (variavel.equals("ERASE")) {
            if (!gravando) {
                numComandosGravados = 0;
                System.out.println("Gravação apagada.");
            } else {
                System.out.println("Erro: Comando inválido durante a gravação.");
            }
        } else if (variavel.equals("VARS")) {
            exibirVariaveis();
        } else if (variavel.equals("RESET")) {
            resetarVariaveis();
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
        } else {

            if (variavel.contains("=")) {
                String[] partes = variavel.split("=");
                if (partes.length == 2) {
                    String nomeVar = partes[0].toUpperCase();
                    if (nomeVar.length() == 1 && nomeVar.charAt(0) >= 'A' && nomeVar.charAt(0) <= 'Z') {
                        try {
                            double valor = Double.parseDouble(partes[1]);
                            atribuirVariavel(nomeVar.charAt(0), valor);
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: Valor inválido para variável.");
                        }
                    } else {
                        System.out.println("Erro: Nome de variável inválido.");
                    }
                }
            }
        }
    }

    private void executarComandos() {
        for (int i = 0; i < numComandosGravados; i++) {
            comando(comandosGravados[i]);
        }
    }

    private void exibirVariaveis() {
        if (numVariaveisDefinidas == 0) {
            System.out.println("Nenhuma variável definida.");
        } else {
            for (int i = 0; i < numVariaveisDefinidas; i++) {
                System.out.println(nomesVariaveis[i] + " = " + valoresVariaveis[i]);
            }
        }
    }

    private void resetarVariaveis() {
        for (int i = 0; i < nomesVariaveis.length; i++) {
            nomesVariaveis[i] = null;
            valoresVariaveis[i] = 0.0; // Resetar para 0.0 (ou outro valor padrão)
        }
        numVariaveisDefinidas = 0;
        System.out.println("Variáveis reiniciadas.");
    }

    private void atribuirVariavel(char nome, double valor) {
        int index = nome - 'A';
        if (nomesVariaveis[index] == null) {
            nomesVariaveis[index] = String.valueOf(nome);
            valoresVariaveis[index] = valor;
            numVariaveisDefinidas++;
        } else {
            valoresVariaveis[index] = valor;
        }
    }
}