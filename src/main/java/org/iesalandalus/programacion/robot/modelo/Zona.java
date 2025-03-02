package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public record Zona(int ancho, int alto) {
    private static int ANCHO_MINIMO = 10;
    private static int ANCHO_MAXIMO = 100;
    private static int ALTO_MINIMO = 10;
    private static int ALTO_MAXIMO = 100;


    public Zona {
        try {
            validarAlto(alto);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Alto no válido.");
        }

        try {
            validarAncho(ancho);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Ancho no válido.");
        }


    }

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);

    }

    private void validarAncho(int ancho) throws IllegalAccessException {
        if (ancho > ANCHO_MAXIMO || ancho < ANCHO_MINIMO) {
            throw new IllegalAccessException("Ancho no valido");
        }
    }

    private void validarAlto(int alto) throws IllegalAccessException {
        if (alto > ALTO_MAXIMO || alto < ALTO_MINIMO) {
            throw new IllegalAccessException("Alto no válido.");

        }
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }

    private boolean perteneceX(int x) {
        return (x >= 0 && x < ancho);
    }

    private boolean perteneceY(int y) {
        return (y >= 0 && y < alto);
    }


}
