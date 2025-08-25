package org.pulsar.simulation.display;

import java.io.PrintStream;

public class TerminalDisplay implements Display {

    private final PrintStream out;

    public TerminalDisplay() {
        this.out = System.out;
    }

    public TerminalDisplay(PrintStream stream) {
        this.out = stream;
    }

    @Override
    public void show(String text) {
        out.println(text);
    }
}
