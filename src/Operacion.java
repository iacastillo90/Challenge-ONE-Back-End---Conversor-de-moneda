public class Operacion {

    private double cantidad;
    private String fromMoneda;
    private String toMoneda;
    private double resultado;

    public Operacion(double cantidad, String fromMoneda, String toMoneda, double resultado) {
        this.cantidad = cantidad;
        this.fromMoneda = fromMoneda;
        this.toMoneda = toMoneda;
        this.resultado = resultado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getFromMoneda() {
        return fromMoneda;
    }

    public String getToMoneda() {
        return toMoneda;
    }

    public double getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Operacion: {" +
                "cantidad=" + cantidad +
                ", fromMoneda='" + fromMoneda + '\'' +
                ", toMoneda='" + toMoneda + '\'' +
                ", resultado=" + resultado +
                '}';
    }
}
