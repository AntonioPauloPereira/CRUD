import java.util.Scanner;
import java.io.IOException;

public class DadosBancarios {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] nomes = new String[5];
        String[] senhas = new String[5];
        
        int opcao_inicial = 0;
        
        do{
            System.out.println("===== DADOS BANCARIOS ===== \n (1) - Cadastrar \n (2) - Login \n (3) - Listar perfis cadastrados \n (0) - Sair \n");
            System.out.print("Digite sua opcao: ");
            opcao_inicial = sc.nextInt();
            
            switch (opcao_inicial){
                case 1:
                nomes = CadastrarNome(nomes);
                senhas = CadastrarSenha(senhas);
                break;
                case 3:
                ListarPerfis(nomes);
                break;
            }
            
            
            
            
        } while (opcao_inicial != 0);
        
        
        
    }
    
    public static String[] CadastrarNome(String[] cad_nomes) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cad_nomes.length; i++) {
            if(cad_nomes[i] == null) {
            System.out.print("Digite seu novo nome: ");
            cad_nomes[i] = sc.nextLine();
                break;
            }
        }
        return cad_nomes;
    }
    public static String[] CadastrarSenha(String[] cad_senhas) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cad_senhas.length; i++) {
            if(cad_senhas[i] == null) {
            System.out.print("Digite sua nova senha: ");
            cad_senhas[i] = sc.nextLine();
                break;
            }
        }
        return cad_senhas;
    }
    public static void ListarPerfis(String[] nomes){
        System.out.println("\n ===== PERFIS CADASTRADOS =====");
        for(int i = 0; i < nomes.length; i++){
            if(nomes[i] != null) {
                System.out.println(nomes[i]);
            }
            
        }
      
    }
    public static boolean login(String[] senhas, String[] nomes){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String log_nomes = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String log_senhas = sc.nextLine();
        
        for(int i = 0; i < nomes.length; i++) {
            if(nomes[i].equals(log_nome))
        }
   
    
    
    }
} //<-- fim do código