package Modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Vivienda extends Gasto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static final double MAX_DEDUCCION = 10000.0;

    public Vivienda(double monto, String descripcion, LocalDate fecha) {
        super(monto, descripcion, fecha);
    }

    @Override
    public String categoria() {
        return "Vivienda";
    }

    @Override
    public double montoDeducible() {
        return Math.min(getMonto(), MAX_DEDUCCION);
    }
}
