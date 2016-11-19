package algorithms;

import components.GraphicContext;
import java.awt.Point;

/**
 *
 * @author Maiko Morales <maiko.moralesr@gmail.com>
 */
public abstract class AbstractDrawingStrategy implements DrawingStrategy {
    
    @Override
    public void drawLine(Point start, Point end, GraphicContext context) {
        drawLine(start.x, start.y, end.x, end.y, context);
    }
    
    @Override
    public void drawLine(int x0, int y0, int x1, int y1, GraphicContext context) {
        int dx = x1 - x0;
        int dy = y1 - y0;

        if (dx == 0 && dy == 0) {
            context.putPixel(x0, y0); // a point
        } else if (dx == 0) { // a vertical line
            int x = x0;
            int y = y0;
            // int offset = dy > 0 ? 1: -1;
            if (dy > 0) {
                while (y <= y1) {
                    context.putPixel(x, y);
                    y = y + 1;
                }
            } else {
                while (y >= y1) {
                    context.putPixel(x, y);
                    y = y - 1;
                }
            }
        } else if (dy == 0) { // an horizontal line
            int x = x0;
            int y = y0;
            if (dx > 0) {
                while (x <= x1) {
                    context.putPixel(x, y);
                    x = x + 1;
                }
            } else {
                while (x >= x1) {
                    context.putPixel(x, y);
                    x = x - 1;
                }
            }
        } else if (dx > 0) {
            if (dy > 0) {
                if (dx > dy) {
                    drawLineCase1(x0, y0, x1, dx, dy, context);
                } else {
                    drawLineCase2(x0, y0, y1, dx, dy, context);
                }
            } else if (dy < 0) {
                if (-1 * dy > dx) {
                    drawLineCase7(x0, y0, y1, dx, dy, context);
                } else {
                    drawLineCase8(x0, y0, x1, dx, dy, context);
                }
            }
        } else if (dx < 0) {
            if (dy > 0) {
                if (-1 * dx < dy) {
                    drawLineCase3(x0, y0, y1, dx, dy, context);
                } else {
                    drawLineCase4(x0, y0, x1, dx, dy, context);
                }
            } else {
                if (-1 * dx > -1 * dy) {
                    drawLineCase5(x0, y0, x1, dx, dy, context);
                } else {
                    drawLineCase6(x0, y0, y1, dx, dy, context);
                }
            }
        }
    }

    protected abstract void drawLineCase1(int x0, int y0, int x1, int dx, int dy, GraphicContext context);

    protected abstract void drawLineCase2(int x0, int y0, int y1, int dx, int dy, GraphicContext context);

    protected abstract void drawLineCase3(int x0, int y0, int y1, int dx, int dy, GraphicContext context);

    protected abstract void drawLineCase4(int x0, int y0, int x1, int dx, int dy, GraphicContext context);

    protected abstract void drawLineCase5(int x0, int y0, int x1, int dx, int dy, GraphicContext context);

    protected abstract void drawLineCase6(int x0, int y0, int y1, int dx, int dy, GraphicContext context);

    protected abstract void drawLineCase7(int x0, int y0, int y1, int dx, int dy, GraphicContext context);

    protected abstract void drawLineCase8(int x0, int y0, int x1, int dx, int dy, GraphicContext context);
}
