package org.pulsar.simulation.printer;

import java.io.PrintStream;

public class ConsolePrinter implements Printer {

    private final PrintStream out;

    private static final String CLEAR_CONSOLE = "\033\143";

    public ConsolePrinter() {
        this(System.out);
    }

    public ConsolePrinter(PrintStream printStream) {
        if (printStream == null) {
            throw new IllegalArgumentException("PrintStream must not be null");
        }
        out = printStream;
    }

    @Override
    public void print(String text) {
        out.print(text);
    }

    @Override
    public void clear() {
        print(CLEAR_CONSOLE);
    }
}
