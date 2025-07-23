package Controlador;

import Modelo.*;
import Vista.VistaConsola;
import Persistencia.PersistenciaContribuyente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorImpuestos {

    private final VistaConsola vista;
    private final PersistenciaContribuyente persistencia;
    private List<Contribuyente> contribuyentes;
    private Contribuyente contribuyenteActual;

    public ControladorImpuestos(VistaConsola vista) {
        this.vista = vista;
        this.persistencia = new PersistenciaContribuyente();
        this.contribuyentes = cargarDatosIniciales();
    }

    public void iniciar() {
        vista.mostrarMensaje("\n=== SISTEMA DE DECLARACION DE IMPUESTOS ===");
        vista.mostrarMensaje("Contribuyentes cargados: " + contribuyentes.size());

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = vista.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 7);

        guardarDatos();
        vista.mostrarMensaje("\n¡Datos guardados correctamente!");
    }

    private List<Contribuyente> cargarDatosIniciales() {
        List<Contribuyente> datos = persistencia.cargarContribuyentes();
        return (datos != null) ? datos : new ArrayList<>();
    }

    private void mostrarMenuPrincipal() {
        vista.mostrarMensaje("\n=== MENU PRINCIPAL ===");
        vista.mostrarMensaje("1. Registrar nuevo contribuyente");
        vista.mostrarMensaje("2. Seleccionar contribuyente");
        vista.mostrarMensaje("3. Agregar sueldo");
        vista.mostrarMensaje("4. Agregar gasto deducible");
        vista.mostrarMensaje("5. Generar declaracion de impuestos");
        vista.mostrarMensaje("6. Mostrar todos los contribuyentes");
        vista.mostrarMensaje("7. Salir");
        vista.mostrarMensaje("Seleccione una opcion: ");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarNuevoContribuyente();
                break;
            case 2:
                seleccionarContribuyente();
                break;
            case 3:
                agregarSueldo();
                break;
            case 4:
                agregarGasto();
                break;
            case 5:
                generarDeclaracion();
                break;
            case 6:
                mostrarContribuyentes();
                break;
            case 7:
                vista.mostrarMensaje("Saliendo del sistema...");
                break;
            default:
                vista.mostrarMensaje("¡Opcion no valida!");
        }
    }

    private void guardarDatos() {
        if (contribuyenteActual != null && !contribuyentes.contains(contribuyenteActual)) {
            contribuyentes.add(contribuyenteActual);
        }
        persistencia.guardarContribuyentes(contribuyentes);
    }

    private void registrarNuevoContribuyente() {
        String[] datos = vista.leerDatosContribuyente();
        Contribuyente nuevo = new Contribuyente(datos[0], datos[1]);
        contribuyentes.add(nuevo);
        contribuyenteActual = nuevo;
        vista.mostrarMensaje("\nContribuyente registrado: " + nuevo.getNombre());
    }

    private void seleccionarContribuyente() {
        if (contribuyentes.isEmpty()) {
            vista.mostrarMensaje("No hay contribuyentes registrados.");
            return;
        }

        vista.mostrarMensaje("\n=== CONTRIBUYENTES REGISTRADOS ===");
        for (int i = 0; i < contribuyentes.size(); i++) {
            vista.mostrarMensaje((i + 1) + ". " + contribuyentes.get(i).getNombre());
        }

        vista.mostrarMensaje("Seleccione un contribuyente (numero): ");
        int seleccion = vista.leerOpcion() - 1;

        if (seleccion >= 0 && seleccion < contribuyentes.size()) {
            contribuyenteActual = contribuyentes.get(seleccion);
            vista.mostrarMensaje("Seleccionado: " + contribuyenteActual.getNombre());
        } else {
            vista.mostrarMensaje("Seleccion invalida.");
        }
    }

    private void mostrarContribuyentes() {
        if (contribuyentes.isEmpty()) {
            vista.mostrarMensaje("No hay contribuyentes registrados.");
            return;
        }

        vista.mostrarMensaje("\n=== LISTA DE CONTRIBUYENTES ===");
        contribuyentes.forEach(c -> vista.mostrarMensaje(
                "Nombre: " + c.getNombre()
                + "  Cedula: " + c.getCedula()
                + "  Sueldos: " + c.calcularIngresoAnual()
        ));
    }

    private void agregarSueldo() {
        double[] datos = vista.leerDatosSueldo();
        int mes = (int) datos[0];
        double monto = datos[1];
        contribuyenteActual.agregarSueldo(monto);
    }

    private void agregarGasto() {
        validarContribuyenteSeleccionado();
        Object[] datosGasto = vista.leerDatosGasto();
        Gasto gasto = crearGasto(
                (int) datosGasto[0],
                (double) datosGasto[1],
                (String) datosGasto[2],
                (LocalDate) datosGasto[3]
        );
        contribuyenteActual.agregarGasto(gasto);
        vista.mostrarMensaje("Gasto agregado (" + gasto.categoria() + ")");
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
                throw new IllegalArgumentException("Tipo de gasto no valido");
        }
    }

    private void generarDeclaracion() {
        validarContribuyenteSeleccionado();
        validarDatosMinimos();
        vista.mostrarMensaje("\n" + contribuyenteActual.generarDeclaracion());
    }

    private void validarContribuyenteSeleccionado() {
        if (contribuyenteActual == null) {
            throw new IllegalStateException("Debe seleccionar un contribuyente primero");
        }
    }

    private void validarDatosMinimos() {
        if (contribuyenteActual.calcularIngresoAnual() == 0) {
            throw new IllegalStateException("Debe registrar sueldos para generar la declaracion");
        }
    }
}
