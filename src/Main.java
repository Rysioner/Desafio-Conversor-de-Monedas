import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HistorialConversiones.limpiarHistorial();
        Scanner teclado = new Scanner(System.in);
        double valor=0;
        while (true){
            try {
                Menu.exhibirMenu();
                int opcion =teclado.nextInt();

                if (opcion == 9){
                    System.out.println("Finalizando aplicación.");
                    break;
                } else if (opcion == 0) {
                    HistorialConversiones.mostrarHistorial();
                } else if (opcion>0 && opcion<9) {
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    valor = teclado.nextDouble();
                }

                Menu.convertirMoneda(opcion,valor);

            } catch (InputMismatchException e){
                System.out.println("Error, ingresó un caracter inválido.");
                System.out.println("Finalizando aplicación.");
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}