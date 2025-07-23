package MainEjecutor;

import Controlador.ControladorImpuestos;
import Vista.VistaConsola;

public class Ejecutor_SistemaImpuestos {

    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorImpuestos controlador = new ControladorImpuestos(vista);

        vista.mostrarMensaje("Sistema de Declaracion de Impuestos");
        controlador.iniciar();
        vista.mostrarMensaje("Programa terminado");
    }
}
