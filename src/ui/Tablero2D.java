package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.Pixel;
import model.Tablero;

public class Tablero2D extends JPanel implements Observer {

    private Pixel2D[][] pixeles2D;
    private final int anchoPixel = 10;
    private final int altoPixel = 10;

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
        if (o instanceof Tablero) {
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
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
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
}
