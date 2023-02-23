import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        boolean salir = false;

        do{

            switch (menuPrincipal(sc)){

                case "1" -> CifrarMensaje.cifrarMensaje();
                case "2" -> DescifrarMensaje.descifrarMensaje();
                case "3" -> salir = true;
                default -> System.out.println("Esa opcion no existe");
            }

        }while(!salir);

    }

    public static String menuPrincipal(Scanner sc) {

        System.out.println("""
                
                
                [1] Cifrar un mensaje
                [2] Descifrar un mensaje
                [3] Salir
                
                """);

        return sc.next();
    }

}