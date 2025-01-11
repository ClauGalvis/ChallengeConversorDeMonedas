package conversorDeMonedas.Modelos;
import java.util.Map;

public record Moneda (String base_code, Map<String, Double> conversion_rates) {


    public Double getTasaDeConversion(String moneda) {
        return conversion_rates.get(moneda);
    }

    public String getBaseCode(String moneda){
        return moneda;
    }


}


