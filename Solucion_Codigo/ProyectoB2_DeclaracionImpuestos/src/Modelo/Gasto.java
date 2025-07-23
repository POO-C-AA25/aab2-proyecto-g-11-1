package Modelo;

import java.time.LocalDate;

public abstract class Gasto {

    protected double monto;
    protected String descripcion;
    protected LocalDate fecha;

    public Gasto(double monto, String descripcion, LocalDate fecha) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public abstract String categoria();

    public abstract double montoDeducible();

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
