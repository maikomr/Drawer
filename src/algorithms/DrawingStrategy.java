package algorithms;

import java.awt.Point;

/**
 *
 * @author Maiko Morales <maiko.moralesr@gmail.com>
 */
public interface DrawingStrategy {
    void drawLine(Point start, Point end, GraphicContext context);
    void drawLine(int x0, int y0, int x1, int y1, GraphicContext context);
    void drawCircle(Point center, int radius, GraphicContext context);
    void drawCircle(int xc, int yc, int r, GraphicContext context);
}
