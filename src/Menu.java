import java.io.IOException;

public class Menu {
    public static void exhibirMenu() {
        System.out.println("""
                **********************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                0) Mostrar Historial
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Dólar =>> Sol peruano
                8) Sol peruano =>> Dólar
                9) Salir
                Elija un opción válida:
                **********************************************************
                """);
    }

    public static void convertirMoneda(int opcion, double valor) throws IOException {

        switch (opcion){
            case 1:{
                HistorialConversiones.guardar("USD", "ARS", valor);
                break;
            }
            case 2:{
                HistorialConversiones.guardar("ARS","USD",valor);
                break;
            }
            case 3:{
                HistorialConversiones.guardar("USD","BRL",valor);
                break;
            }
            case 4:{
                HistorialConversiones.guardar("BRL","USD",valor);
                break;
            }
            case 5:{
                HistorialConversiones.guardar("USD","COP",valor);
                break;
            }
            case 6:{
                HistorialConversiones.guardar("COP","USD",valor);
                break;
            }
            case 7:{
                HistorialConversiones.guardar("USD","PEN",valor);
                break;
            }
            case 8:{
                HistorialConversiones.guardar("PEN","USD",valor);
                break;
            }
            default:{
                System.out.println("Ingresa una opción válida, por favor.");
                break;
            }
        }
    }
}
