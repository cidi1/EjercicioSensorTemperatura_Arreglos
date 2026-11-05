public class SensorTemperatura {
    private String idSensor;
    private double valorActual;
    private String unidad;

    public SensorTemperatura(String idSensor, double valorActual, String unidad) {
        this.idSensor = idSensor;
        this.valorActual = valorActual;
        this.unidad = unidad;
    }

    public double getValorActual() { return valorActual; }
    public void setValorActual(double valorActual) { this.valorActual = valorActual; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public void mostrarLectura() {
        System.out.println("Sensor: " + idSensor + " | Lectura: " + valorActual + " " + unidad);
    }
}
