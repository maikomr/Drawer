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
}
