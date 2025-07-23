package Modelo;

import java.time.LocalDate;

public class Turismo extends Gasto {

    private static final double MAX_DEDUCCION = 4000.0;

    public Turismo(double monto, String descripcion, LocalDate fecha) {
        super(monto, descripcion, fecha);
    }

    @Override
    public String categoria() {
        return "Turismo";
    }

    @Override
    public double montoDeducible() {
        return Math.min(getMonto(), MAX_DEDUCCION);
    }
}
