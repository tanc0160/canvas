package com.tanc0160.canvas;

import com.tanc0160.canvas.model.Point;
import com.tanc0160.canvas.output.StringMemory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCase {

    @Test
    public void create() {
        final Canvas canvas = new Canvas(20, 4);
        final StringMemory output = new StringMemory();
        canvas.print(output);
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
        final Canvas canvas = new Canvas(20, 4);
        canvas.drawLine(new Point(1, 2), new Point(6, 2));
        final StringMemory output = new StringMemory();
        canvas.print(output);
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
        final Canvas canvas = new Canvas(20, 4);
        canvas.drawLine(new Point(6, 2), new Point(6, 4));
        final StringMemory output = new StringMemory();
        canvas.print(output);
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
        final Canvas canvas = new Canvas(20, 4);
        canvas.drawRectangle(new Point(14, 1), new Point(18, 3));
        final StringMemory output = new StringMemory();
        canvas.print(output);
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
        final Canvas canvas = new Canvas(20, 4);
        canvas.fill(new Point(14, 1), 'o');
        final StringMemory output = new StringMemory();
        canvas.print(output);
        String expected =
                "----------------------\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "----------------------\n";
        System.out.print(output.getOutput());
        assertTrue(output.getOutput().equals(expected));
    }

    @Test
    public void sample() {
        final Canvas canvas = new Canvas(20, 4);
        canvas.drawLine(new Point(1, 2), new Point(6, 2));
        canvas.drawLine(new Point(6, 3), new Point(6, 4));
        canvas.drawRectangle(new Point(14, 1), new Point(18, 3));
        canvas.fill(new Point(10, 3), 'o');
        final StringMemory output = new StringMemory();
        canvas.print(output);
        String expected =
                "----------------------\n" +
                "|oooooooooooooxxxxxoo|\n" +
                "|xxxxxxooooooox   xoo|\n" +
                "|     xoooooooxxxxxoo|\n" +
                "|     xoooooooooooooo|\n" +
                "----------------------\n";
        assertTrue(output.getOutput().equals(expected));
    }

}
