//======================================================================================================================
// Projeto CRUD Finalizado!
// Create (feito!) | Read (feito!) | Update (feito!) | Delete (feito!)
//======================================================================================================================

import java.util.Scanner;
import java.io.IOException;

public class SuperMercado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[10];
        double[] preco = new double[10];

        // Carregamento inicial dos dados
        try {
            nomes = (String[]) Gravador.ler("nomes.dat");
            preco = (double[]) Gravador.ler("precos.dat");
        } catch (Exception e) {
            System.out.println("Iniciando novo banco de dados...");
        }

        int opcao_inicial = 0;

        //Menu de interação 
        do {
            System.out.println("\n===== SUPER MERCADO =====");
            System.out.println("(1) - Registrar Produto");
            System.out.println("(2) - Listar Produtos");
            System.out.println("(3) - Editar produto");
            System.out.println("(4) - Excluir Produto");
            System.out.println("(0) - Sair ");
            System.out.print("Digite sua opcao: ");
            opcao_inicial = sc.nextInt();

            switch (opcao_inicial) {
                case 1:
                    nomes = CadastrarProduto(nomes);
                    preco = CadastrarPreco(preco);
                    salvarDados(nomes, preco);
                    break;
                case 2:
                    ListarProduto(nomes, preco);
                    break;
                case 3:
                    EditarProduto(nomes, preco);
                    salvarDados(nomes, preco);
                    break;
                case 4:
                    ExcluirProduto(nomes, preco);
                    salvarDados(nomes, preco);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao_inicial != 0);
    }

    // ================================== MÉTODOS DO SISTEMA ===========================================================

    // --- Cadastra produtos ---
    public static String[] CadastrarProduto(String[] cad_nomes) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cad_nomes.length; i++) {
            if (cad_nomes[i] == null) {
                System.out.print("Digite o nome do produto -> ");
                cad_nomes[i] = sc.nextLine();
                break;
            }
        }
        return cad_nomes;
    }

    // --- Cadastra preços ---
    public static double[] CadastrarPreco(double[] cad_preco) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cad_preco.length; i++) {
            if (cad_preco[i] == 0) {
                System.out.print("Digite o preco do produto -> ");
                cad_preco[i] = sc.nextDouble();
                sc.nextLine(); // Limpa o buffer
                break;
            }
        }
        return cad_preco;
    }
    
    // --- Faz a listagem dos produtos 
    public static void ListarProduto(String[] nomes, double[] precos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n ===== PRODUTOS CADASTRADOS =====");
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null) {
                System.out.println("ID[" + i + "] | Nome: " + nomes[i] + " | Preço: R$ " + precos[i]);
            }
        }
        System.out.print("\n(0) para voltar ao menu: ");
        sc.nextInt();
    }

    // --- Remove produtos da lista --- 
    public static void ExcluirProduto(String[] nomes, double[] preco) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- EXCLUIR PRODUTO ---");
        System.out.println("1. Por Nome");
        System.out.println("2. Por ID");
        System.out.println("3. Sair");
        System.out.print("Escolha -> ");
        int op = sc.nextInt();
        sc.nextLine(); // Limpa buffer

        switch (op) {
            case 1:
                System.out.print("Digite o nome exato -> ");
                String nomeBusca = sc.nextLine();
                for (int i = 0; i < nomes.length; i++) {
                    if (nomes[i] != null && nomes[i].equalsIgnoreCase(nomeBusca)) {
                        nomes[i] = null;
                        preco[i] = 0.0;
                        System.out.println("Produto '" + nomeBusca + "' excluido.");
                        return;
                    }
                }
                System.out.println("Produto não encontrado.");
                break;

            case 2:
                System.out.print("Digite o ID -> ");
                int id = sc.nextInt();
                if (id >= 0 && id < nomes.length && nomes[id] != null) {
                    nomes[id] = null;
                    preco[id] = 0.0;
                    System.out.println("ID " + id + " excluido com sucesso.");
                } else {
                    System.out.println("ID inválido ou vazio.");
                }
                break;

            case 3:
                return;
        }
    }

    // --- Edita os vetores de produtos e preços --- 
    public static void EditarProduto(String nomes[], double precos[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do produto para editar -> ");
        String nomeBusca = sc.nextLine();

        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null && nomes[i].equalsIgnoreCase(nomeBusca)) {
                System.out.print("Novo nome (ou Enter para manter) -> ");
                String novoNome = sc.nextLine();
                if (!novoNome.isEmpty()) {
                    nomes[i] = novoNome;
                }

                System.out.print("Novo preco -> ");
                precos[i] = sc.nextDouble();
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    // -- Salva dados a partir Gravador --- 
    public static void salvarDados(String[] nomes, double[] preco) {
        try {
            Gravador.gravar("nomes.dat", nomes);
            Gravador.gravar("precos.dat", preco);
            System.out.println("[Sistema: Dados salvos no disco]");
        } catch (IOException e) {
            System.out.println("Erro técnico ao salvar dados.");
        }
    }
}
