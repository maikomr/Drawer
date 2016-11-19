package controllers;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.Tablero;
import ui.Tablero2D;

public class ControladorTablero implements MouseListener {
    
    private final Tablero modelo;
    private final Tablero2D vista;

    ControladorTablero(Tablero tablero, Tablero2D tablero2D) {
        this.modelo = tablero;
        this.vista = tablero2D;
        conectar();
    }

    private void conectar() {
        modelo.addObserver(vista);
        modelo.notifyObservers();
        vista.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point ubicacion = vista.getUbicacionPixel(e.getPoint());
        if (ubicacion != null) {
            System.out.println("Se ha hecho click en el pixel: " + ubicacion);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
