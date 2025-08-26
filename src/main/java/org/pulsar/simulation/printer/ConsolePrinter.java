package org.pulsar.simulation.printer;

import java.io.PrintStream;
import java.util.Objects;

public class ConsolePrinter implements Printer {

    private final PrintStream out;

    private static final String CLEAR_CONSOLE_SYMBOL = "\033\143";

    public ConsolePrinter() {
        this(System.out);
    }

    public ConsolePrinter(PrintStream stream) {
        Objects.requireNonNull(stream);
        this.out = stream;
    }

    @Override
    public void print(String text) {
        out.print(text);
    }

    @Override
    public void clear() {
        print(CLEAR_CONSOLE_SYMBOL);
    }
}
