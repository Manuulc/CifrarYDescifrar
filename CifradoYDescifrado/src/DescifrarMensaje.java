import java.io.*;
import java.util.Scanner;

public class DescifrarMensaje {
    private static Scanner sc = new Scanner(System.in);
    public static void descifrarMensaje() {

        System.out.println("Introduce la key de descifrado de 16 caracteres");
        String key = sc.next();

        try {
            System.out.println(obtenerTextoCifrado(key));
        } catch (Exception e) {
            System.err.println("Clave erronea");
            e.printStackTrace();
        }
        sc.close();
    }

    public static String obtenerTextoCifrado(String key){
        String textoCifrado = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("cifrados.txt"));
            textoCifrado = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CifrarYDescifrar.descifrar(textoCifrado, CifrarYDescifrar.obtenerKey(key));
    }
}