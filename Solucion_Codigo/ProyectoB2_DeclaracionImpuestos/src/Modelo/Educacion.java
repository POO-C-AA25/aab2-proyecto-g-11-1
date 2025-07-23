package Modelo;

import java.time.LocalDate;

public class Educacion extends Gasto {

    private static final double MAX_DEDUCCION = 8000.0;

    public Educacion(double monto, String descripcion, LocalDate fecha) {
        super(monto, descripcion, fecha);
    }

    @Override
    public String categoria() {
        return "Educacion";
    }

    @Override
    public double montoDeducible() {
        return Math.min(getMonto(), MAX_DEDUCCION);
    }
}
