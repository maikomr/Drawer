package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Tablero extends Observable {

    private final Pixel[][] pixeles;
    private final int filas;
    private final int columnas;
    private List<Observer> observers;
    
    public Tablero(int filas, int columnas) {
        observers = new ArrayList<>();
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
        this.notifyAllObservers();
    }
    
    public void actualizarPixel(int fila, int columna, Color color) {
        pixeles[fila][columna].setColor(color);
        notifyAllObservers();
    }
    
    public void subscribe(Observer observer) {
        observers.add(observer);
    }
    
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this, null);
        }
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
}
