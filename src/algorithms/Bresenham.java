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
        int x = 0;
        int y = r;
        int d = 1 - r;
        int e = 3;
        int se = -2 * r + 5;
        drawCircle(xc, yc, x, y, context);

        while (y > x) {
            if (d < 0) { // east
                d = d + e;
                e = e + 2;
                se = se + 2;
                x = x + 1;
            } else { // south east
                d = d + se;
                e = e + 2;
                se = se + 4;
                x = x + 1;
                y = y - 1;
            }
            drawCircle(xc, yc, x, y, context);
        }
    }

    private void drawCircle(int xc, int yc, int x, int y, GraphicContext pM) {
        pM.putPixel(xc + x, yc + y);
        pM.putPixel(xc + y, yc + x);
        pM.putPixel(xc + x, yc - y);
        pM.putPixel(xc - y, yc + x);
        pM.putPixel(xc - x, yc - y);
        pM.putPixel(xc - y, yc - x);
        pM.putPixel(xc - x, yc + y);
        pM.putPixel(xc + y, yc - x);
    }
}
