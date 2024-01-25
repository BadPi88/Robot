package org.iesalandalus.programacion.robot.modelo;

import org.iesalandalus.programacion.robot.modelo.Robot;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class ControladorRobot {
    private Robot robot;

    public  ControladorRobot(Robot robot) {
        Objects.requireNonNull(robot,"El robot no puede ser nulo.");
        this.robot = new Robot(Objects.requireNonNull(robot,"El robot no puede ser nulo"));

    }

    public Robot getRobot() {

        return new Robot(robot.getZona(), robot.getOrientacion(), robot.getCoordenada());
    }

    public void ejecutar(char comando) throws OperationNotSupportedException {
        switch (comando) {
            case 'A','a':
                robot.avanzar();
                break;
            case 'I','i':
                robot.girarALaIzquierda();
                break;
            case 'D','d':
                robot.girarALaDerecha();
                break;
            default:
                throw new OperationNotSupportedException("Comando desconocido.");
        }
    }
}
