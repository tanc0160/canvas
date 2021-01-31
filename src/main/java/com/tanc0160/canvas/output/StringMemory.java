package com.tanc0160.canvas.output;


public class StringMemory implements Outputable {
    private String outputValue;

    public String getOutput() {
        return outputValue;
    }

    public void output(String result) {
        outputValue = result;
    }
}
