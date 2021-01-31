package com.tanc0160.canvas.service;

import com.tanc0160.canvas.model.Point;
import com.tanc0160.canvas.output.ConsoleOutput;
import org.junit.Assert;
import org.junit.Test;

public class CanvasServiceTest {

    @Test
    public void validateMapSize() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        assert (canvasService.getHeight() == height);
        assert (canvasService.getWidth() == width);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printBeforeCanvasIsCreated() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.print(new ConsoleOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawLineBeforeCanvasIsCreated() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.drawLine(new Point(1, 2), new Point(2, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawRectangleBeforeCanvasIsCreated() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.drawRectangle(new Point(1, 2), new Point(2, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void fillBeforeCanvasIsCreated() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.fill(new Point(1, 2), 'a');
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWidthLessThanOne() {
        final int height = 4;
        final int width = 0;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateHeightLessThanOne() {
        final int height = 0;
        final int width = 4;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
    }

    @Test
    public void validateGet() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        Assert.assertNull(canvasService.get(new Point(1, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDoubleFillingOnSameCoordinate() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(1, 1), new Point(1, 2));
        canvasService.drawLine(new Point(1, 1), new Point(3, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drawNorHorizontalOrVerticalLine() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(1, 2), new Point(6, 3));
    }

    @Test
    public void drawHorizontalLine() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(1, 2), new Point(6, 2));
        for (int x = 1; x <= 6; x++)
            assert (canvasService.get(new Point(x, 2)) != null &&
                    canvasService.get(new Point(x, 2)) == 'x');
    }

    @Test
    public void drawVerticalLine() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(6, 3), new Point(6, 4));
        for (int y = 3; y <= 4; y++)
            assert (canvasService.get(new Point(6, y)) != null &&
                    canvasService.get(new Point(6, y)) == 'x');
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidXWithLessThanOne() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(0, 1), new Point(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidXMoreThanWidth() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(1, 1), new Point(21, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidYMoreThanHeight() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(1, 1), new Point(20, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidYLessThanOne() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawLine(new Point(1, 0), new Point(20, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidUpperLeftCorner() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawRectangle(new Point(3, 3), new Point(2, 2));
    }

    @Test
    public void drawRectange() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.drawRectangle(new Point(14, 1), new Point(18, 3));
        for (int x = 14; x <= 18; x++) {
            assert (canvasService.get(new Point(x, 1)) != null && canvasService.get(new Point(x, 1)) == 'x');
            assert (canvasService.get(new Point(x, 3)) != null && canvasService.get(new Point(x, 3)) == 'x');
        }
        for (int y = 1; y <= 3; y++) {
            assert (canvasService.get(new Point(14, y)) != null && canvasService.get(new Point(14, y)) == 'x');
            assert (canvasService.get(new Point(18, y)) != null && canvasService.get(new Point(18, y)) == 'x');
        }
    }

    @Test
    public void fill() {
        final int height = 4;
        final int width = 20;
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(width, height);
        canvasService.fill(new Point(1, 1), 't');
        for (int x = 1; x <= width; x++) {
            for (int y = 1; y <= height; y++) {
                assert (canvasService.get(new Point(x, y)) != null && canvasService.get(new Point(x, y)) == 't');
            }
        }
    }

}
