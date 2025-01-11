package conversorDeMonedas.Modelos;

import java.math.BigDecimal;

public class Conversion {
    private BigDecimal valorAConvertir;
    private BigDecimal tasaDeConversion;

    public Conversion(BigDecimal valorAConvertir, Moneda moneda, String codigoMonedaDestino) {
        this.valorAConvertir = valorAConvertir;
        this.tasaDeConversion = BigDecimal.valueOf(moneda.getTasaDeConversion(codigoMonedaDestino));
    }

    public  BigDecimal realizarConversion(){
        BigDecimal resultado = this.valorAConvertir.multiply(this.tasaDeConversion);
        return resultado;
    }
}
