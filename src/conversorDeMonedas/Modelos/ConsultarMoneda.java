package conversorDeMonedas.Modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public  Moneda buscaMoneda(String codigoBase){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/df7cfbe8a148c126ae97a962/latest/"+codigoBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }
}
