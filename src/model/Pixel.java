package model;

import java.awt.Color;

public class Pixel {

    private Color color;
    public static final Color COLOR_POR_DEFECTO = Color.WHITE;
    
    public Pixel(Color color) {
        this.color = color;
    }

    Pixel() {
        this(COLOR_POR_DEFECTO);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
