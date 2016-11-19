package algorithms;

import components.GraphicContext;

/**
 *
 * @author Maiko Morales <maiko.moralesr@gmail.com>
 */
public class Bresenham extends AbstractDrawingStrategy {

    protected void drawLineCase1(int x1, int y1, int x2, int dx, int dy, GraphicContext context) {
        int d = 2 * dy - dx; // start

        int e = 2 * dy;
        int ne = 2 * (dy - dx);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (x < x2) {
            if (d <= 0) { // east
                d = d + e;
                x = x + 1;
            } else { // northeast
                d = d + ne;
                x = x + 1;
                y = y + 1;
            }
            context.putPixel(x, y);
        }
    }

    protected void drawLineCase2(int x1, int y1, int y2, int dx, int dy, GraphicContext context) {
        int d = dy - 2 * dx; // start

        int n = -2 * dx;
        int ne = 2 * (dy - dx);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (y < y2) {
            if (d <= 0) { // northeast
                d = d + ne;
                x = x + 1;
                y = y + 1;
            } else { // north
                d = d + n;
                y = y + 1;
            }
            context.putPixel(x, y);
        }
    }

    protected void drawLineCase3(int x1, int y1, int y2, int dx, int dy, GraphicContext context) {
        int d = -(2 * dx + dy); // start

        int n = -2 * dx;
        int nw = -2 * (dx + dy);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (y < y2) {
            if (d >= 0) {
                d = d + nw;
                x = x - 1;
                y = y + 1;
            } else {
                d = d + n;
                y = y + 1;
            }
            context.putPixel(x, y);
        }
    }

    protected void drawLineCase4(int x1, int y1, int x2, int dx, int dy, GraphicContext context) {
        int d = -(dx + 2 * dy); // start

        int w = -2 * dy;
        int nw = -2 * (dx + dy);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (x > x2) {
            if (d <= 0) { // northwest
                d = d + nw;
                x = x - 1;
                y = y + 1;
            } else { // west
                d = d + w;
                x = x - 1;
            }
            context.putPixel(x, y);
        }
    }

    protected void drawLineCase5(int x1, int y1, int x2, int dx, int dy, GraphicContext context) {
        int d = -2 * dy + dx; // start

        int w = -2 * dy;
        int sw = -2 * (dy - dx);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (x > x2) {
            if (d >= 0) { // southwest
                d = d + sw;
                x = x - 1;
                y = y - 1;
            } else { // west
                d = d + w;
                x = x - 1;
            }
            context.putPixel(x, y);
        }
    }

    protected void drawLineCase6(int x1, int y1, int y2, int dx, int dy, GraphicContext context) {
        int d = 2 * dx - dy; // start

        int s = 2 * dx;
        int sw = 2 * (dx - dy);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (y > y2) {
            if (d <= 0) { // south west
                d = d + sw;
                y = y - 1;
                x = x - 1;
            } else { // south
                d = d + s;
                y = y - 1;
            }
            context.putPixel(x, y);
        }

    }

    protected void drawLineCase7(int x1, int y1, int y2, int dx, int dy, GraphicContext context) {
        int d = 2 * dx + dy; // start

        int s = 2 * dx;
        int se = 2 * (dy + dx);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (y > y2) {
            if (d >= 0) { // south east
                d = d + se;
                x = x + 1;
                y = y - 1;
            } else { // south
                d = d + s;
                y = y - 1;
            }
            context.putPixel(x, y);
        }
    }

    protected void drawLineCase8(int x1, int y1, int x2, int dx, int dy, GraphicContext context) {
        int d = 2 * dy + dx; // start

        int e = 2 * dy;
        int se = 2 * (dy + dx);

        int x = x1;
        int y = y1;
        context.putPixel(x, y);

        while (x < x2) {
            if (d <= 0) { // south east
                d = d + se;
                x = x + 1;
                y = y - 1;
            } else { // east
                d = d + e;
                x = x + 1;
            }
            context.putPixel(x, y);
        }
    }
}
