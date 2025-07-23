package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Contribuyente extends Persona {

    private final List<Double> sueldos;
    private final List<Gasto> gastos;
    private final TablaImpuestos tablaImpuestos;

    public Contribuyente(String nombre, String cedula) {
        super(nombre, cedula);
        this.sueldos = new ArrayList<>();
        this.gastos = new ArrayList<>();
        this.tablaImpuestos = new TablaImpuestos();
    }

    public void agregarSueldo(double sueldo) {
        if (sueldo < 0) {
            throw new IllegalArgumentException("Sueldo no puede ser negativo");
        }
        sueldos.add(sueldo);
    }

    public void agregarGasto(Gasto gasto) {
        if (gasto == null) {
            throw new IllegalArgumentException("Gasto no puede ser nulo");
        }
        gastos.add(gasto);
    }

    public double calcularIngresoAnual() {
        double total = 0;
        for (Double sueldo : sueldos) {
            total += sueldo;
        }
        return total;
    }

    public double calcularGastosDeducibles() {
        double total = 0;
        for (Gasto gasto : gastos) {
            total += gasto.montoDeducible();
        }
        return total;
    }

    @Override
    public double calcularImpuesto() {
        double base = Math.max(0, calcularIngresoAnual() - calcularGastosDeducibles());
        return tablaImpuestos.consultarRango(base).calcularImpuesto(base);
    }

    public String generarDeclaracion() {
        return String.format(
                "DECLARACION DE IMPUESTOS%n" + "Contribuyente: %s%n" + "Cedula: %s%n"
                + "Ingresos anuales: $%,.2f%n" + "Gastos deducibles: $%,.2f%n" + "Impuesto a pagar: $%,.2f",
                getNombre(), getCedula(), calcularIngresoAnual(),
                calcularGastosDeducibles(), calcularImpuesto()
        );
    }
}
