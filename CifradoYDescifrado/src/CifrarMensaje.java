import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CifrarMensaje {

    private static Scanner sc = new Scanner(System.in);
    public static void cifrarMensaje() {


        System.out.println("Introduce el texto a cifrar");
        String texto = sc.next();
        System.out.println("Introduce la key de cifrado de 16 caracteres");
        String clave = sc.next();
        try {
            guardarTextoCifrado(texto, clave);
            System.out.println("Guardado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }

    public static void guardarTextoCifrado(String textoACifrar, String key){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("cifrados.txt"));
            bw.write(CifrarYDescifrar.cifrar(textoACifrar, CifrarYDescifrar.obtenerKey(key)));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.err.println("No se ha podido guardar el texto");
            e.printStackTrace();
        }
    }
}