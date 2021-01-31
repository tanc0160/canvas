package com.tanc0160.canvas;

import com.tanc0160.canvas.model.Point;
import com.tanc0160.canvas.output.Outputable;

import java.util.Stack;

public class Canvas {

    private Character[][] map;
    private int height;
    private int width;

    public Canvas(final int width,
                  final int height) {
        validateWidth(width);
        validateHeight(height);
        map = new Character[height + 2][width + 2];
        this.width = width;
        this.height = height;
        initBorderOfMap();
    }

    private void validateWidth(final int width) {
        if (width <= 0)
            throw new IllegalArgumentException("Width must be greater than zero");
    }

    private void validateHeight(final int height) {
        if (height <= 0)
            throw new IllegalArgumentException("Height must be greater than zero");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Character get(final Point point) {
        validateXAndYCoordinate(point);
        return get(point.getX(), point.getY());
    }

    private Character get(final int x,
                          final int y) {
        return map[y][x];
    }

    private void set(final int x,
                     final int y,
                     final Character value) {
        map[y][x] = value;
    }

    private boolean hasValue(final int x,
                             final int y) {
        return map[y][x] != null;
    }

    private void initBorderOfMap() {
        for (int x = 0; x < map[0].length; x++) {
            set(x, 0, '-');
            set(x, map.length - 1, '-');
        }
        for (int y = 1; y < map.length - 1; y++) {
            set(0, y, '|');
            set(map[y].length - 1, y, '|');
        }
    }

    public void drawLine(final Point point1,
                         final Point point2) {
        validateXAndYCoordinate(point1);
        validateXAndYCoordinate(point2);
        validateLine(point1, point2);

        if (point1.getX() == point2.getX()) {
            final int fromY = point1.getY() > point2.getY() ? point2.getY() : point1.getY();
            final int toY = point1.getY() > point2.getY() ? point1.getY() : point2.getY();
            for (int y = fromY; y <= toY; y++) {
                validateIsPointFilled(point1.getX(), y);
            }
            for (int y = fromY; y <= toY; y++) {
                set(point1.getX(), y, 'x');
            }
        } else {
            final int fromX = point1.getX() > point2.getX() ? point2.getX() : point1.getX();
            final int toX = point1.getX() > point2.getX() ? point1.getX() : point2.getX();
            for (int x = fromX; x <= toX; x++) {
                validateIsPointFilled(x, point1.getY());
            }
            for (int x = fromX; x <= toX; x++) {
                set(x, point1.getY(), 'x');
            }
        }
    }

    private void validateXAndYCoordinate(final Point point) {
        if (point.getX() < 1 || point.getX() > width)
            throw new IllegalArgumentException("Invalid x value " + point.getX());
        if (point.getY() < 1 || point.getY() > height)
            throw new IllegalArgumentException("Invalid y value " + point.getY());
    }

    public void drawRectangle(final Point point1,
                              final Point point2) {
        validateXAndYCoordinate(point1);
        validateXAndYCoordinate(point2);
        if (!(point2.getY() - point1.getY() > 0 && point2.getX() - point1.getX() > 0)) {
            throw new IllegalArgumentException("" +
                    "(x1, y1) must be upper left corner and " +
                    "(x2, y2) must be lower right corner");
        }

        for (int x = point1.getX(); x <= point2.getX(); x++) {
            validateIsPointFilled(x, point1.getY());
            validateIsPointFilled(x, point2.getY());
        }
        for (int y = point1.getY() + 1; y < point2.getY(); y++) {
            validateIsPointFilled(point1.getX(), y);
            validateIsPointFilled(point2.getX(), y);
        }

        for (int x = point1.getX(); x <= point2.getX(); x++) {
            set(x, point1.getY(), 'x');
            set(x, point2.getY(), 'x');
        }

        for (int y = point1.getY() + 1; y < point2.getY(); y++) {
            set(point1.getX(), y, 'x');
            set(point2.getX(), y, 'x');
        }
    }

    public void fill(final Point point,
                     final Character color) {
        validateXAndYCoordinate(point);
        final Stack<Point> stack = new Stack<Point>();
        stack.push(point);
        while (!stack.isEmpty()) {
            final Point currentPoint = stack.pop();
            int y = currentPoint.getY();
            int x = currentPoint.getX();
            set(x, y, color);

            if (y - 1 > 0 && !hasValue(x, y - 1)) {
                stack.push(new Point(x, y - 1));
            }
            if (y + 1 <= height && !hasValue(x, y + 1)) {
                stack.push(new Point(x, y + 1));
            }
            if (x - 1 > 0 && !hasValue(x - 1, y)) {
                stack.push(new Point(x - 1, y));
            }
            if (x + 1 <= width && !hasValue(x + 1, y)) {
                stack.push(new Point(x + 1, y));
            }
        }
    }

    private void validateLine(final Point point1,
                              final Point point2) {
        if (Math.abs(point1.getX() - point2.getX()) > 0 &&
                Math.abs(point1.getY() - point2.getY()) > 0)
            throw new IllegalArgumentException(
                    "Only vertical and horizontal line are supported"
            );
    }

    private void validateIsPointFilled(final int x,
                                       final int y) {
        if (hasValue(x, y))
            throw new IllegalArgumentException("Point (" + x + "," + y + ") " +
                    "has been filled before");
    }

    public void print(final Outputable outputable) {
        final StringBuilder builder = new StringBuilder();
        for (Character[] aMap : map) {
            for (Character anAMap : aMap) {
                if (anAMap != null)
                    builder.append(anAMap);
                else
                    builder.append(' ');
            }
            builder.append("\n");
        }
        outputable.output(builder.toString());
    }
}
