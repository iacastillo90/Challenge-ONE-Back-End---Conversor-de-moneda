import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaConversorMoneda {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/1eba5f42ecfcebbcdea200a1/latest/USD";
    private Moneda tasasDeCambio;

    public ConsultaConversorMoneda() {
        this.tasasDeCambio = obtenerTasasDeCambio();
    }

    private Moneda obtenerTasasDeCambio() {
        URI direccion = URI.create(API_URL);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda tasaDeCambio = new Gson().fromJson(response.body(), Moneda.class);
            if (!"success".equalsIgnoreCase(tasaDeCambio.result())) {
                throw new RuntimeException("Error al obtener las tasas de cambio.");
            }
            return tasaDeCambio;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo conectar con la API de tasas de cambio.", e);
        }
    }

    public double obtenerTasa(String fromMoneda, String toMoneda) {
        Map<String, Double> tasas = tasasDeCambio.conversion_rates();

        if (fromMoneda.equalsIgnoreCase(tasasDeCambio.base_code())) {
            if (!tasas.containsKey(toMoneda)) {
                throw new IllegalArgumentException("La moneda de destino no es válida: " + toMoneda);
            }
            return tasas.get(toMoneda);
        } else if (toMoneda.equalsIgnoreCase(tasasDeCambio.base_code())) {
            if (!tasas.containsKey(fromMoneda)) {
                throw new IllegalArgumentException("La moneda de origen no es válida: " + fromMoneda);
            }
            return 1 / tasas.get(fromMoneda);
        } else {
            // Conversión entre dos monedas diferentes a la base
            if (!tasas.containsKey(fromMoneda) || !tasas.containsKey(toMoneda)) {
                throw new IllegalArgumentException("Una o ambas monedas no son válidas.");
            }
            double tasaFrom = tasas.get(fromMoneda);
            double tasaTo = tasas.get(toMoneda);
            return tasaTo / tasaFrom;
        }
    }

    public void actualizarTasasDeCambio() {
        this.tasasDeCambio = obtenerTasasDeCambio();
    }

    public Map<String, Double> getTasasDeCambio() {
        return tasasDeCambio.conversion_rates();
    }
}
