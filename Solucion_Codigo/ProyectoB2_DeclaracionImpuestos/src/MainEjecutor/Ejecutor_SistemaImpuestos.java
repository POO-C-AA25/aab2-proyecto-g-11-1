package MainEjecutor;

import Controlador.ControladorImpuestos;
import Vista.VistaConsola;

public class Ejecutor_SistemaImpuestos {

    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorImpuestos controlador = new ControladorImpuestos(vista);
        
        try {
            controlador.iniciar();
        } catch (Exception e) {
            vista.mostrarMensaje("Error critico: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Programa terminado");
        }
    }
}
/**
 * === SISTEMA DE DECLARACION DE IMPUESTOS ===
Contribuyentes cargados: 0

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
1

Nombre completo: Francis Tapia
Cedula: 1106082991

Contribuyente registrado: Francis Tapia

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
2

=== CONTRIBUYENTES REGISTRADOS ===
1. Francis Tapia
Seleccione un contribuyente (numero): 
1
Seleccionado: Francis Tapia

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 1
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 2
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 3
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 4
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 5
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 6
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 7
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 8
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 9
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 10
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 11
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
3

Mes (1-12): 12
Monto del sueldo: 500

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
4

Tipo de gasto:
1. Alimentacion
2. Vivienda
3. Educacion
4. Salud
5. Vestimenta
6. Turismo
Seleccione: 1
Monto: 225
Descripcion: Mercado
Fecha (dd/mm/aaaa): 07/01/2024
Gasto agregado (Alimentacion)

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
4

Tipo de gasto:
1. Alimentacion
2. Vivienda
3. Educacion
4. Salud
5. Vestimenta
6. Turismo
Seleccione: 3
Monto: 700
Descripcion: Escuela
Fecha (dd/mm/aaaa): 02/05/2024
Gasto agregado (Educacion)

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
5

DECLARACION DE IMPUESTOS
Contribuyente: Francis Tapia
Cedula: 1106082991
Ingresos anuales: $6.000,00
Gastos deducibles: $925,00
Impuesto a pagar: $0,00

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
6

=== LISTA DE CONTRIBUYENTES ===
Nombre: Francis Tapia  Cedula: 1106082991  Sueldos: 6000.0

=== MENU PRINCIPAL ===
1. Registrar nuevo contribuyente
2. Seleccionar contribuyente
3. Agregar sueldo
4. Agregar gasto deducible
5. Generar declaracion de impuestos
6. Mostrar todos los contribuyentes
7. Salir
Seleccione una opcion: 
7
Saliendo del sistema...
Datos guardados exitosamente en contribuyentes.dat

�Datos guardados correctamente!
Programa terminado
BUILD SUCCESSFUL (total time: 2 minutes 23 seconds)
 */