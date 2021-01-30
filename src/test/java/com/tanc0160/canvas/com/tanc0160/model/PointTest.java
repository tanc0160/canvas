package com.tanc0160.canvas.com.tanc0160.model;

import com.tanc0160.canvas.model.Point;
import org.junit.Test;

public class PointTest {

    @Test
    public void createPointFromString() {
        final Point result = new Point("2", "3");
        assert (result.getX() == 2);
        assert (result.getY() == 3);
    }

    @Test(expected = NumberFormatException.class)
    public void invalidXStringForPointCoordinate() {
        new Point("x", "3");
    }

    @Test(expected = NumberFormatException.class)
    public void invalidYStringForPointCoordinate() {
        new Point("1", "y");
    }
}
