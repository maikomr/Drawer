package algorithms;

import java.awt.Point;

/**
 *
 * @author Maiko Morales <maiko.moralesr@gmail.com>
 */
public class DDA implements DrawingStrategy {

    @Override
    public void drawLine(Point start, Point end, GraphicContext context) {
        drawLine(start.x, start.y, end.x, end.y, context);
    }

    @Override
    public void drawLine(int x0, int y0, int x1, int y1, GraphicContext context) {
        int dx = x1 - x0, dy = y1 - y0, steps, k;
        float incrementoX, incrementoY;
        float x = x0, y = y0;
        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx); // |m|<1>
        } else {
            steps = Math.abs(dy); // |m|>=1
        }
        incrementoX = (float) dx / (float) steps;
        incrementoY = (float) dy / (float) steps;
        context.putPixel(Math.round(x), Math.round(y));
        for (k = 0; k < steps; k++) {
            x += incrementoX;
            y += incrementoY;
            context.putPixel(Math.round(x), Math.round(y));
        }
    }
    
    @Override
    public void drawCircle(Point center, int radius, GraphicContext context) {
        drawCircle(center.x, center.y, radius, context);
    }
    
    @Override
    public void drawCircle(int xc, int yc, int radius, GraphicContext context) {
        // Determinar el angulo de variaci?n
        double theta = Math.toRadians(0);
        // Punto inicial
        int x = radius;
        int y = 0;
        // Mientras el angulo no exceda a 360 dibujar puntos
        while (theta <= 2 * Math.PI) {
            context.putPixel(x + xc, y + yc);
            // Incrementar el ?ngulo
            theta += Math.toRadians(1);
            // C?lcular los valores x e y de forma par?metrica
            double xd = radius * Math.cos(theta);
            x = (int) Math.floor(xd);
            double yd = radius * Math.sin(theta);
            y = (int) Math.floor(yd);
        }
    }
}
