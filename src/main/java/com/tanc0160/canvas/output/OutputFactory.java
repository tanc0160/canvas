package com.tanc0160.canvas.output;

import static com.tanc0160.canvas.output.OutputFactory.OutputType.CONSOLE;
import static com.tanc0160.canvas.output.OutputFactory.OutputType.STRING_MEMORY;

public class OutputFactory {

    public enum OutputType {
        CONSOLE,
        STRING_MEMORY
    }

    private OutputFactory() {
    }

    public static Outputable getOutput(final OutputType outputType) {
        final Outputable outputMethod;
        if (outputType == CONSOLE) {
            outputMethod = new ConsoleOutput();
        } else if (outputType == STRING_MEMORY) {
            outputMethod = new StringMemory();
        } else {
            throw new IllegalArgumentException("Invalid output type: " + outputType.name());
        }
        return outputMethod;
    }
}
