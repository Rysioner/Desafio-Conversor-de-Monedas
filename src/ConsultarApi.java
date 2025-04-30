import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarApi {
    public  double convertirMoneda(String monedaBase, String monedaAConvertir, double valor) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e302e06f6514b3f7083ecc9c/pair/"
                +monedaBase+"/"+monedaAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Moneda moneda = gson.fromJson(response.body(), Moneda.class);
            return moneda.conversion_rate()*valor;
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda.");
        }
    }

}
