package conversorDeMonedas.principal;

import com.google.gson.Gson;
import conversorDeMonedas.Modelos.ConsultarMoneda;
import conversorDeMonedas.Modelos.Conversion;
import conversorDeMonedas.Modelos.Moneda;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Principal {

    public BigDecimal ProcesoConversion(String codigoBase, String monedaDestino){
        ConsultarMoneda consulta = new ConsultarMoneda();
        Scanner inputValor = new Scanner(System.in);
        Moneda moneda = consulta.buscaMoneda(codigoBase);
        System.out.println("Ingresa el valor que deseas convertir");
        BigDecimal valorAConvertir = new BigDecimal(inputValor.nextLine());
        Conversion convertirMoneda = new Conversion(valorAConvertir,moneda,monedaDestino);
        BigDecimal resultadoConversion = convertirMoneda.realizarConversion();
        return resultadoConversion;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = -1;
        String monedaDestino;
        String codigoBase;
        Principal principal = new Principal();

        String menuDeOpciones = """
                **--MENÚ DE OPCIONES--**
                1. Peso colombiano -> Dolar
                2. Dolar -> Peso colombiano
                3. Peso colombiano -> Peso chileno
                4. Peso chileno -> Peso colombiano
                5. Peso chileno -> Dolar
                6. Dolar -> Peso chileno
                0. Salir
                
                Ingresa una opcion: 
                """;

        System.out.println("*********************************************************************");
        System.out.println("Bienvenida(o) al conversor de monedas ;)");
        System.out.println("*********************************************************************");

        while (true){
            System.out.println(menuDeOpciones);
            opcion = input.nextInt();

            if (opcion == 1){
                codigoBase = "COP";
                monedaDestino = "USD";
                BigDecimal resultado = principal.ProcesoConversion(codigoBase,monedaDestino);
                System.out.println("Conversion realizada: "+ resultado);


            } else if (opcion == 2) {
                codigoBase = "USD";
                monedaDestino = "COP";
                BigDecimal resultado = principal.ProcesoConversion(codigoBase,monedaDestino);
                System.out.println("Conversion realizada: "+ resultado);

            } else if (opcion == 3){
                codigoBase = "COP";
                monedaDestino = "CLP";
                BigDecimal resultado = principal.ProcesoConversion(codigoBase,monedaDestino);
                System.out.println("Conversion realizada: "+ resultado);

            } else if (opcion == 4) {
                codigoBase = "CLP";
                monedaDestino = "COP";
                BigDecimal resultado = principal.ProcesoConversion(codigoBase,monedaDestino);
                System.out.println("Conversion realizada: "+ resultado);

            }else if (opcion == 5) {
                codigoBase = "CLP";
                monedaDestino = "USD";
                BigDecimal resultado = principal.ProcesoConversion(codigoBase,monedaDestino);
                System.out.println("Conversion realizada: "+ resultado);

            } else if (opcion == 6) {
                codigoBase = "USD";
                monedaDestino = "CLP";
                BigDecimal resultado = principal.ProcesoConversion(codigoBase,monedaDestino);
                System.out.println("Conversion realizada: "+ resultado);

            } else if (opcion == 0) {
                System.out.println("Saliendo del programa");
                break;
            } else {
                System.out.println("Por favor, seleccione una opcion correcta");
            }

        }


    }
}
