package Modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Vestimenta extends Gasto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final double MAX_DEDUCCION = 3000.0;

    public Vestimenta(double monto, String descripcion, LocalDate fecha) {
        super(monto, descripcion, fecha);
    }

    @Override
    public String categoria() {
        return "Vestimenta";
    }

    @Override
    public double montoDeducible() {
        return Math.min(getMonto(), MAX_DEDUCCION);
    }
}
