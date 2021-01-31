package com.tanc0160.canvas.output;

import org.junit.Test;

import static com.tanc0160.canvas.output.OutputFactory.OutputType.CONSOLE;
import static com.tanc0160.canvas.output.OutputFactory.OutputType.STRING_MEMORY;
import static org.junit.Assert.assertTrue;

public class OutputFactoryTest {

    @Test
    public void createConsoleOutput() {
        final Outputable outputMethod = OutputFactory.getOutput(CONSOLE);
        assertTrue(outputMethod instanceof ConsoleOutput);
    }

    @Test
    public void createStringMemory() {
        final Outputable outputMethod = OutputFactory.getOutput(STRING_MEMORY);
        assertTrue(outputMethod instanceof StringMemory);
    }
}
