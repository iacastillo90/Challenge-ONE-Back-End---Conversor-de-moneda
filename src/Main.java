import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaConversorMoneda consulta = new ConsultaConversorMoneda();

        System.out.println("##############################################");
        System.out.println("Sea Bienvenido/a al Conversor de Monedas. 👌\n");

        GeneradorDeArchivo generador = new GeneradorDeArchivo();  // Instancia única
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Ingrese el valor a convertir: ");
                double valor = Double.parseDouble(lectura.nextLine());

                System.out.println("\nSeleccione la opción de conversión:");
                System.out.println("1) Dólar (USD) → Peso Argentino (ARS)");
                System.out.println("2) Peso Argentino (ARS) → Dólar (USD)");
                System.out.println("3) Dólar (USD) → Real Brasileño (BRL)");
                System.out.println("4) Real Brasileño (BRL) → Dólar (USD)");
                System.out.println("5) Dólar (USD) → Peso Colombiano (COP)");
                System.out.println("6) Peso Colombiano (COP) → Dólar (USD)");
                System.out.println("7) Salir\n");
                System.out.print("Por favor, elija una opción: \n");
                System.out.println("##############################################");

                int opcion = Integer.parseInt(lectura.nextLine());

                double resultado;
                String fromMoneda = "";
                String toMoneda = "";

                switch (opcion) {
                    case 1:
                        fromMoneda = "USD";
                        toMoneda = "ARS";
                        System.out.println("\nDólar (USD) → Peso Argentino (ARS)");
                        break;
                    case 2:
                        fromMoneda = "ARS";
                        toMoneda = "USD";
                        System.out.println("\nPeso Argentino (ARS) → Dólar (USD)");
                        break;
                    case 3:
                        fromMoneda = "USD";
                        toMoneda = "BRL";
                        System.out.println("\nDólar (USD) → Real Brasileño (BRL)");
                        break;
                    case 4:
                        fromMoneda = "BRL";
                        toMoneda = "USD";
                        System.out.println("\nReal Brasileño (BRL) → Dólar (USD)");
                        break;
                    case 5:
                        fromMoneda = "USD";
                        toMoneda = "COP";
                        System.out.println("\nDólar (USD) → Peso Colombiano (COP)");
                        break;
                    case 6:
                        fromMoneda = "COP";
                        toMoneda = "USD";
                        System.out.println("\nPeso Colombiano (COP) → Dólar (USD)");
                        break;
                    case 7:
                        System.out.println("\nGracias por usar el conversor de monedas. Hasta luego. 👋");
                        continuar = false;
                        continue;
                    default:
                        System.out.println("\nOpción no válida. Por favor, intente nuevamente.\n");
                        continue;
                }

                double tasa = consulta.obtenerTasa(fromMoneda, toMoneda);
                resultado = valor * tasa;

                Operacion operacion = new Operacion(valor, fromMoneda, toMoneda, resultado);

                generador.guardarOperacion(operacion);

                System.out.printf("Resultado: %.2f %s\n\n", resultado, toMoneda);

            } catch (NumberFormatException e) {
                System.out.println("\nEntrada inválida. Por favor, ingrese un número válido.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("\nOcurrió un error inesperado: " + e.getMessage() + "\n");
            }
        }

        lectura.close();
    }
}
