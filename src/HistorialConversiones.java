import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistorialConversiones {
    public static void guardar(String monedaBase, String monedaConvertida, double valor) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fecha = LocalDateTime.now().format(formatter);
        Conversion conversion = new Conversion(monedaBase, monedaConvertida, valor, fecha);
        System.out.println(conversion.toString());

        try (FileWriter escritura = new FileWriter("historial_monedas.txt", true)) {
            escritura.write(conversion.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Error al guardar la conversión: " + e.getMessage());
        }
    }

    public static void mostrarHistorial() {
        try (BufferedReader br = new BufferedReader(new FileReader("historial_monedas.txt"))) {
            String linea;
            System.out.println("***** Historial de Conversiones *****");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el historial: " + e.getMessage());
        }
    }

    public static void limpiarHistorial() {
        try (FileWriter fw = new FileWriter("historial_monedas.txt", false)) {
            // No se escribe nada pq esto borra el contenido
        } catch (IOException e) {
            System.err.println("Error al limpiar el historial: " + e.getMessage());
        }
    }
}
