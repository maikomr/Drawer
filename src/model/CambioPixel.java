package model;

import java.awt.Color;

public class CambioPixel {
    
    private final int fila;
    private final int columna;
    private final Color color;

    public CambioPixel(int fila, int columna, Color color) {
        this.fila = fila;
        this.columna = columna;
        this.color = color;
    }
    
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Color getColor() {
        return color;
    }
}
