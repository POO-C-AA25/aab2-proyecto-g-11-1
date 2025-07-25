package Modelo;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final String nombre;
    private final String cedula;

    public Persona(String nombre, String cedula) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre requerido");
        }
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("Cedula requerida");
        }

        this.nombre = nombre;
        this.cedula = cedula;
    }

    public abstract double calcularImpuesto();

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }
}
