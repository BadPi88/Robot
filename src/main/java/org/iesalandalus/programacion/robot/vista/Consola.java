package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola() {
        // Constructor privado para evitar la instanciación de la clase
    }

    public static int elegirOpcion() {
        mostrarMenuPrincipal();
        System.out.println("Elige una opción: ");
        return Entrada.entero();
    }

    public static Zona elegirZona() {
        Zona zona = null;
        do {
            System.out.println("Introduce el ancho de la zona: ");
            int ancho = Entrada.entero();
            System.out.println("Introduce el alto de la zona: ");
            int alto = Entrada.entero();

            try {
                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException e) {
                System.out.println("Error al crear la zona. Inténtalo de nuevo.");
            }
        } while (zona == null);

        return zona;
    }

    public static Orientacion elegirOrientacion() {
        mostrarMenuOrientacion();
        System.out.println("Elige una orientación: ");
        int opcion = Entrada.entero();
        while (opcion < 1 || opcion > Orientacion.values().length) {
            System.out.println("Opción no válida. Inténtalo de nuevo.");
            mostrarMenuOrientacion();
            System.out.println("Elige una orientación: ");
            opcion = Entrada.entero();
        }
        return Orientacion.values()[opcion - 1];
    }

    public static Coordenada elegirCoordenada() {
        System.out.println("Introduce la coordenada X: ");
        int x = Entrada.entero();
        System.out.println("Introduce la coordenada Y: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando() {
        System.out.println("Elige el comando a ejecutar (A, I, D): ");
        char comando = Entrada.caracter();
        while (comando != 'A' && comando != 'I' && comando != 'D') {
            System.out.println("Comando no válido. Inténtalo de nuevo.");
            System.out.println("Elige el comando a ejecutar (A, I, D): ");
            comando = Entrada.caracter();
        }
        return comando;
    }

    public static void mostrarRobot(Robot robot) {
        if (robot != null) {
            System.out.println(robot);
        } else {
            System.out.println("El robot es nulo.");
        }
    }

    public static void despedirse() {
        System.out.println("¡Hasta luego!");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("1. Controlar un robot por defecto");
        System.out.println("2. Indicar zona de un robot");
        System.out.println("3. Indicar zona y orientación de un robot");
        System.out.println("4. Indicar zona, orientación y coordenada inicial de un robot");
        System.out.println("5. Ejecutar comando");
        System.out.println("6. Salir");
    }

    private static void mostrarMenuOrientacion() {
        System.out.println("1. Norte");
        System.out.println("2. Noreste");
        System.out.println("3. Este");
        System.out.println("4. Sureste");
        System.out.println("5. Sur");
        System.out.println("6. Suroeste");
        System.out.println("7. Oeste");
        System.out.println("8. Noroeste");
    }
}

