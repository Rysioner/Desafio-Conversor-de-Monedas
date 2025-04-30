public class Conversion {

    private String monedaBase;
    private String monedaConvertida;
    private double valor;
    private double resultado;
    private String fecha;

    public Conversion(String monedaBase, String monedaConvertida, double valor, String fecha){

        this.valor = valor;
        this.monedaBase = monedaBase;
        this.monedaConvertida = monedaConvertida;
        this.fecha = fecha;

        ConsultarApi consulta = new ConsultarApi();
        resultado = consulta.convertirMoneda(monedaBase,monedaConvertida,valor);
    }

    @Override
    public String toString() {
        return String.format("%s | El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]",
                fecha, valor, monedaBase, resultado, monedaConvertida);
    }
}
