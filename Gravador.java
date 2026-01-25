import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Gravador {
     public static void gravar(String arquivo, Object objeto) throws FileNotFoundException, IOException{
        FileOutputStream outFile = new FileOutputStream(arquivo); // cria um arquivo
        ObjectOutputStream s = new ObjectOutputStream(outFile); // recebe o arquivo criado
        s.writeObject(objeto); // grava os bytes do objeto no arquivo
        s.close();
    }

    public static Object ler(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream inFile = new FileInputStream(arquivo); // abre o arquivo
        ObjectInputStream s = new ObjectInputStream(inFile); // recebe o arquivo que esta armazenado os objetos
        Object objeto = s.readObject(); // le os bytes do objeto serializavel e retorna o objeto
        s.close();

        return objeto;
    }
}
