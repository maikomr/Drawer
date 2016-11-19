package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.CambioPixel;
import model.Pixel;
import model.Tablero;

public class Tablero2D extends JPanel implements Observer {

    private Pixel2D[][] pixeles2D;
    private final int anchoPixel = 20;
    private final int altoPixel = 20;

    public Tablero2D() {
        super();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (pixeles2D != null) {
            int filas = pixeles2D.length;
            int columnas = pixeles2D[0].length;
            for (int fila = 0; fila < filas; fila++) {
                for (int columna = 0; columna < columnas; columna++) {
                    pixeles2D[fila][columna].paint(g);
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null && arg instanceof CambioPixel) {
            CambioPixel cambioPixel = (CambioPixel) arg;
            Pixel2D pixel2D = pixeles2D[cambioPixel.getFila()][cambioPixel.getColumna()];
            pixel2D.setColor(cambioPixel.getColor());
            repaint();
        } else if (o instanceof Tablero) {
            Tablero tablero = (Tablero) o;
            actualizarTablero(tablero);
            repaint();
        }
    }

    private void actualizarTablero(Tablero tablero) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        Pixel[][] pixeles = tablero.getPixeles();
        pixeles2D = new Pixel2D[filas][columnas];
        for (int fila = getX(); fila < filas; fila++) {
            for (int columna = getY(); columna < columnas; columna++) {
                Pixel pixel = pixeles[fila][columna];
                Pixel2D pixel2D = new Pixel2D(pixel.getColor());
                Rectangle bounds = new Rectangle(
                        new Point(columna * anchoPixel, fila * altoPixel),
                        new Dimension(anchoPixel, altoPixel));
                pixel2D.setBounds(bounds);
                pixeles2D[fila][columna] = pixel2D;
            }
        }
    }

    public Point getUbicacionPixel(Point point) {
        Point ubicacion = null;
        if (pixeles2D != null) {
            int filas = pixeles2D.length;
            int columnas = pixeles2D[0].length;
            for (int fila = 0; fila < filas; fila++) {
                for (int columna = 0; columna < columnas; columna++) {
                    if(pixeles2D[fila][columna].contiene(point)) {
                        return new Point(fila,columna);
                    }
                }
            }
        }
        return ubicacion;
    }
}
