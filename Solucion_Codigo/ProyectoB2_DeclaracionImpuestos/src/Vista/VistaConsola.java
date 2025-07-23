
package Vista;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VistaConsola {

    private final Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\nSISTEMA DE DECLARACION DE IMPUESTOS");
        System.out.println("1. Registrar contribuyente");
        System.out.println("2. Agregar sueldo mensual");
        System.out.println("3. Agregar gasto deducible");
        System.out.println("4. Generar declaracion");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String[] leerDatosContribuyente() {
        System.out.print("\nNombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Cedula: ");
        String cedula = scanner.nextLine();
        return new String[]{nombre, cedula};
    }

    public double[] leerDatosSueldo() {
        System.out.print("\nMes (1-12): ");
        int mes = Integer.parseInt(scanner.nextLine());
        System.out.print("Monto del sueldo: ");
        double monto = Double.parseDouble(scanner.nextLine());
        return new double[]{mes, monto};
    }

    public Object[] leerDatosGasto() {
        System.out.println("\nTipo de gasto:");
        System.out.println("1. Alimentacion");
        System.out.println("2. Vivienda");
        System.out.println("3. Educacion");
        System.out.println("4. Salud");
        System.out.println("5. Vestimenta");
        System.out.println("6. Turismo");
        System.out.print("Seleccione: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Monto: ");
        double monto = Double.parseDouble(scanner.nextLine());

        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();

        System.out.print("Fecha (dd/mm/aaaa): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return new Object[]{tipo, monto, descripcion, fecha};
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }

    public void mostrarDeclaracion(String declaracion) {
        System.out.println("\n" + declaracion);
    }
}
