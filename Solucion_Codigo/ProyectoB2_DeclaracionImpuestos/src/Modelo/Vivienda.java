package Modelo;

import java.time.LocalDate;

public class Vivienda extends Gasto {

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
