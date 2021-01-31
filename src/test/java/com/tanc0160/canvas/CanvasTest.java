package com.tanc0160.canvas;

import com.tanc0160.canvas.model.Point;
import org.junit.Test;

public class CanvasTest {

    @Test
    public void validateMapSize() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        assert (canvas.getHeight() == height);
        assert (canvas.getWidth() == width);
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawNorHorizontalOrVerticalLine() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(1, 2), new Point(6, 3));
    }

    @Test
    public void drawHorizontalLine() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(1, 2), new Point(6, 2));
        for (int x = 1; x <= 6; x++)
            assert (canvas.get(new Point(x, 2)) != null &&
                    canvas.get(new Point(x, 2)) == 'x');
    }

    @Test
    public void drawVerticalLine() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(6, 3), new Point(6, 4));
        for (int y = 3; y <= 4; y++)
            assert (canvas.get(new Point(6, y)) != null &&
                    canvas.get(new Point(6, y)) == 'x');
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidXWithLessThanOne() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(0, 1), new Point(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidXMoreThanWidth() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(1, 1), new Point(21, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidYMoreThanHeight() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(1, 1), new Point(20, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidYLessThanOne() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(1, 0), new Point(20, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidUpperLeftCorner() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawRectangle(new Point(3, 3), new Point(2, 2));
    }

    @Test
    public void drawRectange() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawRectangle(new Point(14, 1), new Point(18, 3));
        for (int x = 14; x <= 18; x++) {
            assert (canvas.get(new Point(x, 1)) != null && canvas.get(new Point(x, 1)) == 'x');
            assert (canvas.get(new Point(x, 3)) != null && canvas.get(new Point(x, 3)) == 'x');
        }
        for (int y = 1; y <= 3; y++) {
            assert (canvas.get(new Point(14, y)) != null && canvas.get(new Point(14, y)) == 'x');
            assert (canvas.get(new Point(18, y)) != null && canvas.get(new Point(18, y)) == 'x');
        }
    }

    @Test
    public void fill() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.fill(new Point(1, 1), 't');
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                assert (canvas.get(new Point(x, y)) != null && canvas.get(new Point(x, y)) == 't');
            }
        }
    }

}
