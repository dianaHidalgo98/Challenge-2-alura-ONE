import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultCurrency {
    public CurrencyData searchCurrency(String nameCurrency1, String nameCurrency2, double amount) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/01e4be1c479e721ee6efc9c2/pair/" +
                nameCurrency1 + "/" + nameCurrency2 + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CurrencyData.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("CurrencyData conversion not available. Try Again.");
        }
    }
}
