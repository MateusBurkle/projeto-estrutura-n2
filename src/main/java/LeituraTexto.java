import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class LeituraTexto {
    public static int totalLinhas = 0;
    public static int totalPalavras = 0;

    public static void carregarTexto(String caminhoArquivo, ABB arvore) {
        totalLinhas = 0;
        totalPalavras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                totalLinhas++;
                linha = tratamentoLinha(linha);
                String[] palavras = linha.split(" ");
                for (String p : palavras) {
                    if (!p.isEmpty()) {
                        arvore.inserir(new Palavra(p));
                        totalPalavras++;
                    }
                }
            }
            System.out.println("TEXTO CARREGADO");
        } catch (IOException x) {
            System.out.println("Erro ao ler o arquivo: " + x.getMessage());
        }
    }

    private static String tratamentoLinha(String linha){
        linha = linha.toUpperCase();
        linha = linha.replaceAll("[.,;:!?\"()]", "");
        linha = linha.replace("-", " ");
        linha = substituirNum(linha);
        return linha;
    }

    private static String substituirNum(String linha){
        return linha.replace("1", "UM")
                    .replace("2", "DOIS")
                    .replace("3", "TRES")
                    .replace("4", "QUATRO")
                    .replace("5", "CINCO")
                    .replace("6", "SEIS")
                    .replace("7", "SETE")
                    .replace("8", "OITO")
                    .replace("9", "NOVE")
                    .replace("0", "ZERO");
    }
}
