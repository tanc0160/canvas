package com.tanc0160.canvas;

import com.tanc0160.canvas.model.Point;
import org.junit.Test;

public class CanvasTest {

    @Test
    public void validateInternalMapSize() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        final Character[][] result = canvas.getMap();
        assert (result.length == height + 2);
        assert (result[0].length == width + 2);
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
        final Character[][] result = canvas.getMap();
        for (int x = 1; x <= 6; x++)
            assert (result[2][x] != null && result[2][x] == 'x');
    }

    @Test
    public void drawVerticalLine() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.drawLine(new Point(6, 3), new Point(6, 4));
        final Character[][] result = canvas.getMap();
        for (int y = 3; y <= 4; y++)
            assert (result[y][6] != null && result[y][6] == 'x');
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
        final Character[][] result = canvas.getMap();
        for (int x = 14; x <= 18; x++) {
            assert (result[1][x] != null && result[1][x] == 'x');
            assert (result[3][x] != null && result[3][x] == 'x');
        }
        for (int y = 1; y <= 3; y++) {
            assert (result[y][14] != null && result[y][14] == 'x');
            assert (result[y][18] != null && result[y][18] == 'x');
        }
    }

    @Test
    public void fill() {
        final int height = 4;
        final int width = 20;
        final Canvas canvas = new Canvas(width, height);
        canvas.fill(new Point(1, 1), 't');
        final Character[][] result = canvas.getMap();
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                assert (result[y][x] != null && result[y][x] == 't');
            }
        }
    }

}
