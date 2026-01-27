//Projeto CRUD
//Create (em andamento)
//Read (não feito)
//Update[edit the file] (não feito)
//Delete (não feito)

import java.util.Scanner;
import java.io.IOException;

//====================================Bloco mãe/ Menu ==================================================================
public class SuperMercado {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[5];     //
        double[] preco = new double[5];
        
        int opcao_inicial = 0;
        
        do{
            System.out.println("===== SUPER MERCADO ===== \n (1) - Registrar Produto \n (2) - Listar Produtos \n (0) - Sair \n");
            System.out.print("Digite sua opcao: ");
            opcao_inicial = sc.nextInt();
            
            switch (opcao_inicial){
                case 1:
                nomes = CadastrarProduto(nomes);
                double[] cadPreco = CadastrarPreco(preco);
                
                break;
                case 2:
                ListarProduto(nomes, preco);
                break;
                default: 
                    System.out.println("Opcao invalida!");
            }
            
            
            
            
        } while (opcao_inicial != 0);
        
        
        
    }
    //======================================================-========================================================
    
    //==================================  Cadastrar produtos ========================================================
    public static String[] CadastrarProduto(String[] cad_nomes) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cad_nomes.length; i++) {
            if(cad_nomes[i] == null) {
            System.out.print("Digite o nome do produto: ");
            cad_nomes[i] = sc.nextLine();
                break;
            }
        }
        return cad_nomes;
    }

    //=================================================================================================================

    //============================ Cadastar preços ========================================================================
    public static double[] CadastrarPreco(double[] cad_preco) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cad_preco.length; i++) {
            if(cad_preco[i] == 0) {
            System.out.print("Digite o preco do produto: ");
            cad_preco[i] = sc.nextDouble();
                break;
            }
        }
        return cad_preco;
    }
    
    //=========================== Listar =======================================================================================
    public static void ListarProduto(String[] nomes, double[] precos){ 
        System.out.println("\n ===== PRODUTOS CADASTRADOS ====="); 
        for(int i = 0; i < nomes.length; i++){
            if(nomes[i] != null) {
                System.out.println("Nome: "+nomes[i]+"   Preco: R$"+precos[i]);
                           }
        }
    //================================================================================================================================    
      
    }
} //<-- fim do código
