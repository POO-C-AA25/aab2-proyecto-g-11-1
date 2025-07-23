package Controlador;

import Modelo.*;
import Vista.VistaConsola;
import java.time.LocalDate;

public class ControladorImpuestos {

    private final VistaConsola vista;
    private Contribuyente contribuyente;

    public ControladorImpuestos(VistaConsola vista) {
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            try {
                switch (opcion) {
                    case 1:
                        registrarContribuyente();
                        break;
                    case 2:
                        agregarSueldo();
                        break;
                    case 3:
                        agregarGasto();
                        break;
                    case 4:
                        generarDeclaracion();
                        break;
                    case 5:
                        vista.mostrarMensaje("Saliendo del sistema...");
                        break;
                    default:
                        vista.mostrarError("Opción no válida");
                }
            } catch (Exception e) {
                vista.mostrarError(e.getMessage());
            }
        } while (opcion != 5);
    }

    private void registrarContribuyente() {
        String[] datos = vista.leerDatosContribuyente();
        contribuyente = new Contribuyente(datos[0], datos[1]);
        vista.mostrarMensaje("Contribuyente registrado exitosamente");
    }

    private void agregarSueldo() {
        if (contribuyente == null) {
            vista.mostrarError("Debe registrar un contribuyente primero");
            return;
        }

        double[] datos = vista.leerDatosSueldo();
        contribuyente.agregarSueldo(datos[1]);
        vista.mostrarMensaje("Sueldo del mes " + (int) datos[0] + " agregado");
    }

    private void agregarGasto() {
        if (contribuyente == null) {
            vista.mostrarError("Debe registrar un contribuyente primero");
            return;
        }

        Object[] datos = vista.leerDatosGasto();
        Gasto gasto = crearGasto(
                (int) datos[0], (double) datos[1], (String) datos[2], (LocalDate) datos[3]
        );
        contribuyente.agregarGasto(gasto);
        vista.mostrarMensaje("Gasto de " + gasto.categoria() + " agregado");
    }

    private Gasto crearGasto(int tipo, double monto, String descripcion, LocalDate fecha) {
        switch (tipo) {
            case 1:
                return new Alimentacion(monto, descripcion, fecha);
            case 2:
                return new Vivienda(monto, descripcion, fecha);
            case 3:
                return new Educacion(monto, descripcion, fecha);
            case 4:
                return new Salud(monto, descripcion, fecha);
            case 5:
                return new Vestimenta(monto, descripcion, fecha);
            case 6:
                return new Turismo(monto, descripcion, fecha);
            default:
                throw new IllegalArgumentException("Tipo de gasto no válido");
        }
    }

    private void generarDeclaracion() {
        if (contribuyente == null) {
            vista.mostrarError("Debe registrar un contribuyente primero");
            return;
        }

        if (contribuyente.calcularIngresoAnual() == 0) {
            vista.mostrarError("Debe agregar sueldos primero");
            return;
        }

        vista.mostrarDeclaracion(contribuyente.generarDeclaracion());
    }
}
