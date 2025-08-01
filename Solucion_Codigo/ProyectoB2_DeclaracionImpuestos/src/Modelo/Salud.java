package Modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Salud extends Gasto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final double MAX_DEDUCCION = 7000.0;

    public Salud(double monto, String descripcion, LocalDate fecha) {
        super(monto, descripcion, fecha);
    }

    @Override
    public String categoria() {
        return "Salud";
    }

    @Override
    public double montoDeducible() {
        return Math.min(getMonto(), MAX_DEDUCCION);
    }
}
