package com.example.demo;

public class Persona {
    private int pisoActual;
    private int pisoDestino;

    public Persona(int pisoActual, int pisoDestino) {
        this.pisoActual = pisoActual;
        this.pisoDestino = pisoDestino;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }
}
