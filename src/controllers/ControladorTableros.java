package controllers;

import algorithms.DrawingStrategy;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import model.Tablero;
import ui.Tablero2D;

public class ControladorTableros implements MouseListener {
    
    private final List<Tablero> tableros;
    private final List<Tablero2D> tableros2D;
    private final List<DrawingStrategy> estrategiasDeDibujo;
    private Point inicio;
    private Point fin;    

    ControladorTableros() {
        tableros = new ArrayList<>();
        tableros2D = new ArrayList<>();
        estrategiasDeDibujo = new ArrayList<>();
    }
    
    public void conectar(Tablero tablero, Tablero2D tablero2D, DrawingStrategy estrategiaDeDibujo) {
        tableros.add(tablero);
        tableros2D.add(tablero2D);
        estrategiasDeDibujo.add(estrategiaDeDibujo);
        tablero.addObserver(tablero2D);
        tablero.notifyObservers();
        tablero2D.addMouseListener(this);
    }
    
    private void dibujarLineas() {
        for (Tablero tablero : tableros) {
            int indice = tableros.indexOf(tablero);
            DrawingStrategy estrategiaDeDibujo = estrategiasDeDibujo.get(indice);
            estrategiaDeDibujo.drawLine(inicio, fin, tablero);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Tablero2D tablero2D : tableros2D) {
            Point ubicacion = tablero2D.getUbicacionPixel(e.getPoint());
            if (ubicacion != null) {
                if(inicio == null) {
                    inicio = new Point(ubicacion);
                } else if(fin == null) {
                    fin = new Point(ubicacion);
                    dibujarLineas();
                    inicio = null;
                    fin = null;
                }
                break;
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
