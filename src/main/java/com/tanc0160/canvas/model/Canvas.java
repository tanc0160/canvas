package com.tanc0160.canvas.model;

public class Canvas {

    private Character[][] map;
    private int height;
    private int width;

    public Canvas(final int width,
                  final int height) {
        this.height = height;
        this.width = width;
        map = new Character[height + 2][width + 2];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Character get(final int x,
                         final int y) {
        return map[y][x];
    }

    public void set(final int x,
                    final int y,
                    final Character value) {
        map[y][x] = value;
    }

    public boolean hasValue(final int x,
                             final int y) {
        return map[y][x] != null;
    }

    public String toString() {
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
        return builder.toString();
    }
}
