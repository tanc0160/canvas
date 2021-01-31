package com.tanc0160.canvas;

import com.tanc0160.canvas.model.Point;
import com.tanc0160.canvas.output.StringMemory;
import com.tanc0160.canvas.service.CanvasService;
import com.tanc0160.canvas.service.CanvasServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCase {

    @Test
    public void create() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(20, 4);
        final StringMemory output = new StringMemory();
        canvasService.print(output);
        String expected =
                "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

    @Test
    public void drawHorizontalLine() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(20, 4);
        canvasService.drawLine(new Point(1, 2), new Point(6, 2));
        final StringMemory output = new StringMemory();
        canvasService.print(output);
        String expected =
                "----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

    @Test
    public void drawVerticalLine() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(20, 4);
        canvasService.drawLine(new Point(6, 2), new Point(6, 4));
        final StringMemory output = new StringMemory();
        canvasService.print(output);
        String expected =
                "----------------------\n" +
                "|                    |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "----------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

    @Test
    public void drawRectangle() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(20, 4);
        canvasService.drawRectangle(new Point(14, 1), new Point(18, 3));
        final StringMemory output = new StringMemory();
        canvasService.print(output);
        String expected =
                "----------------------\n" +
                "|             xxxxx  |\n" +
                "|             x   x  |\n" +
                "|             xxxxx  |\n" +
                "|                    |\n" +
                "----------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

    @Test
    public void fill() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(20, 4);
        canvasService.fill(new Point(14, 1), 'o');
        final StringMemory output = new StringMemory();
        canvasService.print(output);
        String expected =
                "----------------------\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "----------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

    @Test
    public void sample() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(20, 4);
        canvasService.drawLine(new Point(1, 2), new Point(6, 2));
        canvasService.drawLine(new Point(6, 3), new Point(6, 4));
        canvasService.drawRectangle(new Point(14, 1), new Point(18, 3));
        canvasService.fill(new Point(10, 3), 'o');
        final StringMemory output = new StringMemory();
        canvasService.print(output);
        String expected =
                "----------------------\n" +
                "|oooooooooooooxxxxxoo|\n" +
                "|xxxxxxooooooox   xoo|\n" +
                "|     xoooooooxxxxxoo|\n" +
                "|     xoooooooooooooo|\n" +
                "----------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

    @Test
    public void sample2() {
        final CanvasService canvasService = new CanvasServiceImpl();
        canvasService.create(50, 4);
        canvasService.drawLine(new Point(2, 2), new Point(6, 2));
        canvasService.drawLine(new Point(19, 1), new Point(19, 4));
        canvasService.drawRectangle(new Point(10, 1), new Point(18, 3));
        canvasService.drawRectangle(new Point(1, 3), new Point(3, 4));
        canvasService.drawRectangle(new Point(21, 1), new Point(30, 4));
        canvasService.fill(new Point(7, 1), 't');
        canvasService.fill(new Point(49, 1), 'z');
        final StringMemory output = new StringMemory();
        canvasService.print(output);
        String expected =
                "----------------------------------------------------\n" +
                "|tttttttttxxxxxxxxxx xxxxxxxxxxzzzzzzzzzzzzzzzzzzzz|\n" +
                "|txxxxxtttx       xx x        xzzzzzzzzzzzzzzzzzzzz|\n" +
                "|xxxttttttxxxxxxxxxx x        xzzzzzzzzzzzzzzzzzzzz|\n" +
                "|xxxtttttttttttttttx xxxxxxxxxxzzzzzzzzzzzzzzzzzzzz|\n" +
                "----------------------------------------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

}
