package Modelo;

public class Rango {

    private final double desde;
    private final double hasta;
    private final double fraccionBasica;
    private final double impuestoFraccion;
    private final double porcentaje;

    public Rango(double desde, double hasta, double fraccionBasica, double impuestoFraccion, double porcentaje) {
        this.desde = desde;
        this.hasta = hasta;
        this.fraccionBasica = fraccionBasica;
        this.impuestoFraccion = impuestoFraccion;
        this.porcentaje = porcentaje;
    }

    public boolean enRango(double valor) {
        return valor >= desde && valor <= hasta;
    }

    public double calcularImpuesto(double ingreso) {
        return impuestoFraccion + ((ingreso - desde) * porcentaje / 100);
    }
}
