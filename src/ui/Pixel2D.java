package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

public class Pixel2D extends JComponent {

    private Color color;
    
    public static final Color DEFAULT_PIXEL_COLOR = Color.WHITE;
    
    public Pixel2D() {
        this(DEFAULT_PIXEL_COLOR);
    }
    
    public Pixel2D(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Dimension size = getSize();
        Color graphicsColor = g.getColor();
        g.setColor(DEFAULT_PIXEL_COLOR);
        g.fillRect(getX(), getY(), size.width, size.height); // color grid
        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY(), size.width, size.height); // color border with BLACK lines
        g.setColor(graphicsColor);
    }

    boolean contiene(Point point) {
        return (point.x > getX() && point.x < getX() + getWidth()) 
                && (point.y > getY() && point.y < getY() + getHeight());
    }
}
