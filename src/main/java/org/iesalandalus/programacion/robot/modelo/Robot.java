package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {
    private Coordenada coordenada;
    private Zona zona;
    private Orientacion orientacion;

    public Robot() {
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;

    }

    public Robot(Zona zona) {
        setZona(zona);
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion) {

        setZona(zona);
        coordenada = zona.getCentro();
        setOrientacion(orientacion);

    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        setZona(zona);
        setCoordenada(coordenada);
        setOrientacion(orientacion);
    }

    public Robot(Robot robot) {
        if (robot == null) {
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        setZona(robot.getZona());
        setOrientacion(robot.getOrientacion());
        setCoordenada(robot.getCoordenada());
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        } else if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        if (zona == null) {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        if (orientacion == null) {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        this.orientacion = orientacion;
    }

    public void avanzar() throws OperationNotSupportedException {

        Coordenada nuevaCoordenada = new Coordenada(0,0);

        switch (orientacion) {
            case NORTE:
                nuevaCoordenada = (new Coordenada(coordenada.x(), coordenada.y() + 1));
                break;
            case NORESTE:
                nuevaCoordenada = (new Coordenada(coordenada.x() + 1, coordenada.y() + 1));
                break;
            case ESTE:
                nuevaCoordenada = (new Coordenada(coordenada.x() + 1, coordenada.y()));
                break;
            case SURESTE:
                nuevaCoordenada = (new Coordenada(coordenada.x() + 1, coordenada.y() - 1));
                break;
            case SUR:
                nuevaCoordenada = (new Coordenada(coordenada.x(), coordenada.y() - 1));
                break;
            case SUROESTE:
                nuevaCoordenada = (new Coordenada(coordenada.x() - 1, coordenada.y() - 1));
                break;
            case OESTE:
                nuevaCoordenada = (new Coordenada(coordenada.x() - 1, coordenada.y()));
                break;
            case NOROESTE:
                nuevaCoordenada= (new Coordenada(coordenada.x() - 1, coordenada.y() + 1));
                break;

        }
        if (!zona.pertenece(nuevaCoordenada)) {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }
        setCoordenada(nuevaCoordenada);


    }

    public void girarALaDerecha() {

        switch (getOrientacion()) {
            case NORTE:
                setOrientacion(Orientacion.NORESTE);
                break;
            case NORESTE:
                setOrientacion(Orientacion.ESTE);
                break;
            case ESTE:
                setOrientacion(Orientacion.SURESTE);
                break;
            case SURESTE:
                setOrientacion(Orientacion.SUR);
                break;
            case SUR:
                setOrientacion(Orientacion.SUROESTE);
                break;
            case SUROESTE:
                setOrientacion(Orientacion.OESTE);
                break;
            case OESTE:
                setOrientacion(Orientacion.NOROESTE);
                break;
            case NOROESTE:
                setOrientacion(Orientacion.NORTE);
                break;
        }


    }

    public void girarALaIzquierda() {

        switch (getOrientacion()) {
            case NORTE:
                setOrientacion(Orientacion.NOROESTE);
                break;
            case NORESTE:
                setOrientacion(Orientacion.NORTE);
                break;
            case ESTE:
                setOrientacion(Orientacion.NORESTE);
                break;
            case SURESTE:
                setOrientacion(Orientacion.ESTE);
                break;
            case SUR:
                setOrientacion(Orientacion.SURESTE);
                break;
            case SUROESTE:
                setOrientacion(Orientacion.SUR);
                break;
            case OESTE:
                setOrientacion(Orientacion.SUROESTE);
                break;
            case NOROESTE:
                setOrientacion(Orientacion.OESTE);
                break;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (!Objects.equals(coordenada, robot.coordenada)) return false;
        if (!Objects.equals(zona, robot.zona)) return false;
        return orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, zona, orientacion);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordenada=" + coordenada +
                ", zona=" + zona +
                ", orientacion=" + orientacion +
                '}';
    }
}