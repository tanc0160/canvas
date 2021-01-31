package com.tanc0160.canvas.service;

import com.tanc0160.canvas.model.Point;
import com.tanc0160.canvas.output.Outputable;

public interface CanvasService {
    void create(final int width, final int height);

    int getHeight();

    int getWidth();

    Character get(final Point point);

    void drawLine(final Point point1, final Point point2);

    void drawRectangle(final Point point1, final Point point2);

    void fill(final Point point, final Character color);

    void print(final Outputable outputable);
}
