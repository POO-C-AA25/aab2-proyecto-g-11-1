package Modelo;

import java.util.ArrayList;
import java.util.List;

public class TablaImpuestos {

    private final List<Rango> rangos;

    public TablaImpuestos() {
        rangos = new ArrayList<>();
        rangos.add(new Rango(0, 11722, 0, 0, 0));
        rangos.add(new Rango(11722.01, 14930, 0, 0, 5));
        rangos.add(new Rango(14930.01, 18660, 0, 160.90, 10));
        rangos.add(new Rango(18660.01, 22400, 0, 534.10, 12));
        rangos.add(new Rango(22400.01, 32760, 0, 984.10, 15));
        rangos.add(new Rango(32760.01, 43120, 0, 2539.10, 20));
        rangos.add(new Rango(43120.01, 53480, 0, 4611.10, 25));
        rangos.add(new Rango(53480.01, 63840, 0, 7203.10, 30));
        rangos.add(new Rango(63840.01, 103740, 0, 10315.10, 35));
        rangos.add(new Rango(103740.01, Double.MAX_VALUE, 0, 24278.60, 37));
    }

    public Rango consultarRango(double ingreso) {
        for (Rango rango : rangos) {
            if (rango.enRango(ingreso)) {
                return rango;
            }
        }
        throw new IllegalArgumentException("Ingreso fuera de rango");
    }
}
