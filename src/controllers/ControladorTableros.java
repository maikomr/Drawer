package controllers;

import algorithms.DrawingStrategy;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Tablero;
import ui.Tablero2D;

public class ControladorTableros implements MouseListener {
    
    private final List<Tablero> tableros;
    private final List<Tablero2D> tableros2D;
    private final List<DrawingStrategy> estrategiasDeDibujo;
    private Point inicio;
    private Point fin;
    private Color colorActual;

    ControladorTableros() {
        tableros = new ArrayList<>();
        tableros2D = new ArrayList<>();
        estrategiasDeDibujo = new ArrayList<>();
        colorActual = Color.black;
    }
    
    public void conectar(Tablero tablero, Tablero2D tablero2D, DrawingStrategy estrategiaDeDibujo) {
        tableros.add(tablero);
        tableros2D.add(tablero2D);
        estrategiasDeDibujo.add(estrategiaDeDibujo);
        tablero.addObserver(tablero2D);
        tablero.notifyObservers();
        tablero2D.addMouseListener(this);
    }
    
    public Color getColorActual() {
        return colorActual;
    }

    public void setColorActual(Color colorActual) {
        this.colorActual = colorActual;
    }
    
    private void dibujarLineas() {
        for (Tablero tablero : tableros) {
            tablero.setColorActual(colorActual);
            int indice = tableros.indexOf(tablero);
            DrawingStrategy estrategiaDeDibujo = estrategiasDeDibujo.get(indice);
            Date tiempoInicial = new Date();
            estrategiaDeDibujo.drawLine(inicio, fin, tablero);
            Date tiempoFinal = new Date();
            long diferencia = tiempoFinal.getTime() - tiempoInicial.getTime();
            System.out.println(String.format("Diferencia de tiempo para %s: %d", estrategiaDeDibujo, diferencia));
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
