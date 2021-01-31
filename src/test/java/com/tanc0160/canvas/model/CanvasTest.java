package com.tanc0160.canvas.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CanvasTest {

    @Test
    public void setAndGetValue() {
        final Canvas canvas = new Canvas(4, 5);
        assertFalse(canvas.hasValue(2, 4));
        canvas.set(2, 4, 'a');
        assertTrue(canvas.hasValue(2, 4));
        assert(canvas.get(2, 4) == 'a');
    }

    @Test
    public void getString() {
        final Canvas canvas = new Canvas(4, 5);
        assertFalse(canvas.toString().equals(""));
    }
}
