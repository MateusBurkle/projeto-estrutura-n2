
import java.util.Scanner;

public class ArquivoPrincipal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ABB arvore = new ABB();

            int opcao;

            do {
                System.out.println("\n--- MENU ---");
                System.out.println("1 - Carregar o texto");
                System.out.println("2 - Estatísticas");
                System.out.println("3 - Buscar palavra");
                System.out.println("4 - Exibir texto (in-order)");
                System.out.println("5 - Procurar palavras pelo o número de letras (Função inventada)");
                System.out.println("6 - Encerrar");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> {
                        LeituraTexto.carregarTexto("src/resources/LetraMusica.txt", arvore);
                    }

                    case 2 -> {
                        System.out.println("\n--- ESTATÍSTICAS ---");
                        System.out.println("Total de linhas: " + LeituraTexto.totalLinhas);
                        System.out.println("Total de palavras: " + LeituraTexto.totalPalavras);
                        System.out.println("Total de palavras distintas: " + arvore.contarNos());
                        Palavra maisLonga = arvore.encontrarLonga();
                        System.out
                                .println("Palavra mais longa: " + maisLonga.palavra + " (" + maisLonga.palavra.length()
                                        + " letras)");
                    }

                    case 3 -> {
                        System.out.print("Digite a palavra para buscar: ");
                        String palavraBuscada = sc.nextLine().toUpperCase();
                        Palavra resultado = arvore.buscar(palavraBuscada);
                        if (resultado != null) {
                            System.out
                                    .println("A palavra \"" + resultado.palavra + "\" apareceu " + resultado.ocorrencias
                                            + " vezes.");
                        } else {
                            System.out.println("Palavra não encontrada.");
                        }
                    }

                    case 4 -> {
                        System.out.println("\n--- PALAVRAS EM ORDEM ALFABÉTICA ---");
                        arvore.exibirEmOrdem();
                    }
                    case 5 -> {
                        System.out.print("Digite o número de letras que as palavras devem ter: ");
                        try {
                            String entrada = sc.nextLine();
                            int tamanho = Integer.parseInt(entrada);

                            System.out.println("\n--- Palavras com " + tamanho + " letras ---");
                            arvore.exibirPorTamanho(tamanho);
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                        }
                    }
                    case 6 -> System.out.println("Encerrando o programa...");
                    default -> System.out.println("Opção inválida!");
                }

            } while (opcao != 6);
        }
    }
}
