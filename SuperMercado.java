//======================================================================================================================
// Projeto CRUD Finalizado!
// Create (feito!) | Read (feito!) | Update (feito!) | Delete (feito!)
//======================================================================================================================

import java.util.Scanner;
import java.io.IOException;

public class SuperMercado {

    public static void main(String[] args) {
        String[] nomes = new String[10];
        double[] preco = new double[10];

        // Carregamento inicial dos dados
        try {
            nomes = (String[]) Gravador.ler("nomes.dat");
            preco = (double[]) Gravador.ler("precos.dat");
        } catch (Exception e) {
            System.out.println("Iniciando novo banco de dados...");
        }

        executarMenu(nomes, preco);
    }

    // ================================== FUNÇÃO DO MENU PRINCIPAL =================================================
    
    public static void executarMenu(String[] nomes, double[] preco) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        //Menu de interação 
        do {
            System.out.println("\n===== SUPER MERCADO =====");
            System.out.println("(1) - Registrar Produto");
            System.out.println("(2) - Listar Produtos");
            System.out.println("(3) - Editar produto");
            System.out.println("(4) - Consultar Produto");
            System.out.println("(5) - Excluir Produto");
            System.out.println("(0) - Sair ");
            System.out.print("Digite sua opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    nomes = cadastrarProduto(nomes);
                    preco = cadastrarPreco(preco);
                    salvarDados(nomes, preco);
                    break;
                case 2:
                    listarProduto(nomes, preco);
                    break;
                case 3:
                    editarProduto(nomes, preco);
                    salvarDados(nomes, preco);
                    break;
                case 4:
                    consultarProduto(nomes, preco);
                    break;
                case 5:
                    excluirProduto(nomes, preco);
                    salvarDados(nomes, preco);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ================================== MÉTODOS DO SISTEMA ===========================================================

    // --- Cadastra produtos ---
    public static String[] cadastrarProduto(String[] nomes) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] == null) {
                System.out.print("Digite o nome do produto -> ");
                nomes[i] = sc.nextLine();
                break;
            }
        }
        return nomes;
    }

    // --- Cadastra preços ---
    public static double[] cadastrarPreco(double[] precos) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < precos.length; i++) {
            if (precos[i] == 0) {
                System.out.print("Digite o preço do produto -> ");
                precos[i] = sc.nextDouble();
                sc.nextLine(); // Limpa o buffer
                break;
            }
        }
        return precos;
    }

    // --- Faz a listagem dos produtos 
    public static void listarProduto(String[] nomes, double[] precos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n ===== PRODUTOS CADASTRADOS =====");
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null) {
                System.out.println("ID[" + i + "] | Nome: " + nomes[i] + " | Preço: R$ " + precos[i]);
            }
        }
        System.out.print("\n(0) para voltar ao menu: ");
        sc.nextLine(); 
    }

    // --- Remove produtos da lista --- 
    public static void excluirProduto(String[] nomes, double[] preco) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- EXCLUIR PRODUTO ---");
        System.out.println("1. Por Nome");
        System.out.println("2. Por ID");
        System.out.println("3. Excluir tudo");
        System.out.println("4. Sair");
        System.out.print("Escolha -> ");
        int op = sc.nextInt();
        sc.nextLine(); // Limpa buffer

        switch (op) {
            case 1:
                System.out.print("Digite o nome -> ");
                String busca = sc.nextLine();
                for (int i = 0; i < nomes.length; i++) {
                    if (nomes[i] != null && nomes[i].equalsIgnoreCase(busca)) {
                        nomes[i] = null; preco[i] = 0.0;
                        System.out.println("Produto removido.");
                        return;
                    }
                }
                break;
            case 2:
                System.out.print("ID -> ");
                int id = sc.nextInt();
                if (id >= 0 && id < nomes.length) {
                    nomes[id] = null; preco[id] = 0.0;
                    System.out.println("ID removido.");
                }
                break;
            case 3:
                for (int i = 0; i < nomes.length; i++) {
                    nomes[i] = null; preco[i] = 0.0;
                }
                System.out.println("Tudo excluído.");
                break;
            case 4:
                return;
        }
    }

    // --- Edita os vetores de produtos e preços --- 
    public static void editarProduto(String[] nomes, double[] precos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- EDITAR PRODUTO ---");
        System.out.println("1. Por Nome");
        System.out.println("2. Por ID");
        System.out.println("3. Sair");
        System.out.print("Insira escolha -> ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                System.out.print("Nome do produto para editar -> ");
                String busca = sc.nextLine();
                for (int i = 0; i < nomes.length; i++) {
                    if (nomes[i] != null && nomes[i].equalsIgnoreCase(busca)) {
                        System.out.print("Novo nome -> ");
                        nomes[i] = sc.nextLine();
                        System.out.print("Novo preço -> ");
                        precos[i] = sc.nextDouble();
                        return;
                    }
                }
                break;
            case 2:
                System.out.print("ID -> ");
                int id = sc.nextInt(); sc.nextLine();
                if (id >= 0 && id < nomes.length && nomes[id] != null) {
                    System.out.print("Novo nome -> ");
                    nomes[id] = sc.nextLine();
                    System.out.print("Novo preço -> ");
                    precos[id] = sc.nextDouble();
                }
                break;
            case 3:
                return;
        }
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

    // --- Consulta um produto específico por Nome ou ID --- 
public static void consultarProduto(String[] nomes, double[] preco) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n--- CONSULTAR PRODUTO ---");
    System.out.println("1. Por Nome");
    System.out.println("2. Por ID");
    System.out.println("3. Voltar");
    System.out.print("Escolha -> ");
    int op = sc.nextInt();
    sc.nextLine(); // Limpa buffer

    switch (op) {
        case 1:
            System.out.print("Digite o nome para busca -> ");
            String busca = sc.nextLine();
            boolean encontradoNome = false;
            for (int i = 0; i < nomes.length; i++) {
                if (nomes[i] != null && nomes[i].equalsIgnoreCase(busca)) {
                    System.out.println("\n[Produto Encontrado]");
                    System.out.println("ID: " + i + " | Nome: " + nomes[i] + " | Preço: R$ " + preco[i]);
                    encontradoNome = true;
                }
            }
            if (!encontradoNome) System.out.println("Produto não encontrado.");
            break;

        case 2:
            System.out.print("Digite o ID -> ");
            int id = sc.nextInt();
            if (id >= 0 && id < nomes.length && nomes[id] != null) {
                System.out.println("\n[Produto Encontrado]");
                System.out.println("ID: " + id + " | Nome: " + nomes[id] + " | Preço: R$ " + preco[id]);
            } else {
                System.out.println("ID inválido ou inexistente.");
            }
            break;

        case 3:
            return;
    }
}


}
