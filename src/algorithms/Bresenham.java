package algorithms;

import java.awt.Point;

/**
 *
 * @author Maiko Morales <maiko.moralesr@gmail.com>
 */
public class Bresenham implements DrawingStrategy {

    @Override
    public void drawLine(Point start, Point end, GraphicContext context) {
        drawLine(start.x, start.y, end.x, end.y, context);
    }

    @Override
    public void drawLine(int x0, int y0, int x1, int y1, GraphicContext context) {
        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = x1 - x0;
        dy = y1 - y0;
        // determinamos el punto inicial
        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        } else {
            stepy = 1;
        }

        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        } else {
            stepx = 1;
        }

        x = x0;
        y = y0;
        context.putPixel(x, y);

        if (dx > dy) {
            p = 2 * dy - dx;
            incE = 2 * dy;
            incNE = 2 * (dy - dx);
            while (x != x1) {
                x = x + stepx;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepy;
                    p = p + incNE;
                }
                context.putPixel(x, y);
            }
        } else {
            p = 2 * dx - dy;
            incE = 2 * dx;
            incNE = 2 * (dx - dy);
            while (y != y1) {
                y = y + stepy;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepx;
                    p = p + incNE;
                }
                context.putPixel(x, y);
            }
        }
    }
    
    @Override
    public void drawCircle(Point center, int radius, GraphicContext context) {
        drawCircle(center.x, center.y, radius, context);
    }

    @Override
    public void drawCircle(int xc, int yc, int r, GraphicContext context) {
        //// Punto inicial del círculo
        int x = 0;
        int y = r;
        
        // Cálcular el parámetro inicial de decisión
        int pk = 1 - r;

        // verificar el pk para determinar las posiciones de pixel siguuientes
        while (x <= y) {
            context.putPixel(xc + x, yc + y);
            context.putPixel(xc - x, yc + y);
            context.putPixel(xc + x, yc - y);
            context.putPixel(xc - x, yc - y);
            context.putPixel(yc + y, xc + x);
            context.putPixel(yc - y, xc + x);
            context.putPixel(yc + y, xc - x);
            context.putPixel(yc - y, xc - x);

            if (pk < 0) {
                pk += 2 * (x + 1) + 1;
                x++;
            } else { // pk>=0
                pk += 2 * (x + 1) + 1 - 2 * (y - 1);
                x++;
                y--;
            }
        }
    }
}
