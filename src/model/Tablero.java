package model;

import components.GraphicContext;
import java.awt.Color;
import java.util.Observable;

public class Tablero extends Observable implements GraphicContext {

    private final Pixel[][] pixeles;
    private final int filas;
    private final int columnas;
    
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        pixeles = new Pixel[filas][columnas];
        inicializarPixeles();
    }
    
    private void inicializarPixeles() {
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Pixel pixel = new Pixel();
                pixeles[fila][columna] = pixel;
            }
        }
        setChanged();
    }
    
    public void actualizarPixel(int fila, int columna, Color color) {
        pixeles[fila][columna].setColor(color);
        setChanged();
        notifyObservers(new CambioPixel(fila, columna, color));
    }
    
    public Pixel[][] getPixeles() {
        return pixeles;
    }

    public int getFilas() {
        return filas;
    }
    
    public int getColumnas() {
        return columnas;
    }

    @Override
    public void putPixel(int x, int y) {
        actualizarPixel(x, y, Color.black);
    }

    public void limpiar() {
        inicializarPixeles();
        notifyObservers();
    }
}
