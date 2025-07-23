package Persistencia;

import Modelo.Contribuyente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaContribuyente {
    private static final String ARCHIVO = "contribuyentes.dat";
    
    public void guardarContribuyentes(List<Contribuyente> contribuyentes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
             new BufferedOutputStream(
             new FileOutputStream(ARCHIVO)))) {
            
            oos.writeObject(contribuyentes);
            System.out.println("Datos guardados exitosamente en " + ARCHIVO);
            
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Contribuyente> cargarContribuyentes() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
             new BufferedInputStream(
             new FileInputStream(ARCHIVO)))) {
            
            return (List<Contribuyente>) ois.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
