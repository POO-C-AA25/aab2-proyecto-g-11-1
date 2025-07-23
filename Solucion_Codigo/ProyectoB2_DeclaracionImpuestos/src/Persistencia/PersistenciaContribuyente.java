package Persistencia;

import Modelo.Contribuyente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaContribuyente {

    private static final String ARCHIVO = "contribuyentes.dat";

    public void guardarContribuyentes(List<Contribuyente> contribuyentes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(contribuyentes);
        } catch (IOException e) {
            System.err.println("Error al guardar contribuyentes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Contribuyente> cargarContribuyentes() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            return (List<Contribuyente>) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error al cargar contribuyentes: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
