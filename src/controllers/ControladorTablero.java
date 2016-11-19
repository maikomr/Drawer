package controllers;

import algorithms.DrawingStrategy;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Tablero;
import ui.Tablero2D;

public class ControladorTablero implements MouseListener {
    
    private final Tablero modelo;
    private final Tablero2D vista;
    private Point inicio;
    private Point fin;
    private DrawingStrategy estrategiaDeDibujo;

    ControladorTablero(Tablero tablero, Tablero2D tablero2D, DrawingStrategy estrategiaDeDibujo) {
        this.modelo = tablero;
        this.vista = tablero2D;
        this.estrategiaDeDibujo = estrategiaDeDibujo;
        conectar();
    }

    private void conectar() {
        modelo.addObserver(vista);
        modelo.notifyObservers();
        vista.addMouseListener(this);
    }

    public void setEstrategiaDeDibujo(DrawingStrategy estrategiaDeDibujo) {
        this.estrategiaDeDibujo = estrategiaDeDibujo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point ubicacion = vista.getUbicacionPixel(e.getPoint());
        if (ubicacion != null) {
            if(inicio == null) {
                inicio = new Point(ubicacion);
            } else if(fin == null) {
                fin = new Point(ubicacion);
                estrategiaDeDibujo.drawLine(inicio, fin, modelo);
                inicio = null;
                fin = null;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        Point ubicacion = vista.getUbicacionPixel(e.getPoint());
//        inicio = new Point(ubicacion);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        Point ubicacion = vista.getUbicacionPixel(e.getPoint());
//        fin = new Point(ubicacion);
//        estrategiaDeDibujo.drawLine(inicio, fin, modelo);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
