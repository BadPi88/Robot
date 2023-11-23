package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class Main {

    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {
        int opcion;

        do {
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 6); // 6 para salir

        Consola.despedirse();
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                controlarRobotDefecto();
                break;
            case 2:
                controlarRobotZona();
                break;
            case 3:
                controlarRobotZonaOrientacion();
                break;
            case 4:
                controlarRobotZonaOrientacionCoordenada();
                break;
            case 5:
                ejecutarComando();
                break;
            case 6:
                // Salir
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    }

    private static void controlarRobotDefecto() {
        Robot robot = new Robot(); // Constructor por defecto
        controladorRobot = new ControladorRobot(robot);
    }

    private static void controlarRobotZona() {
        Zona zona = Consola.elegirZona();
        Robot robot = new Robot(zona); // Constructor con zona
        controladorRobot = new ControladorRobot(robot);
    }

    private static void controlarRobotZonaOrientacion() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Robot robot = new Robot(zona, orientacion); // Constructor con zona y orientación
        controladorRobot = new ControladorRobot(robot);
    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        Zona zona = Consola.elegirZona();
        Orientacion orientacion = Consola.elegirOrientacion();
        Coordenada coordenada = Consola.elegirCoordenada();
        Robot robot = new Robot(zona, orientacion, coordenada); // Constructor con zona, orientación y coordenada
        controladorRobot = new ControladorRobot(robot);
    }

    private static void ejecutarComando() {
        if (controladorRobot == null) {
            System.out.println("No hay un robot para ejecutar comandos. Elige una opción para crear o seleccionar un robot.");
            return;
        }

        char comando = Consola.elegirComando();

        try {
            controladorRobot.ejecutar(comando);
            Consola.mostrarRobot(controladorRobot.getRobot());
        } catch (OperationNotSupportedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

