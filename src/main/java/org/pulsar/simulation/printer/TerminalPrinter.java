package org.pulsar.simulation.printer;

import java.io.PrintStream;

public class TerminalPrinter implements Printer {

    private final PrintStream out;

    private static final String CLEAR_CONSOLE_SYMBOL = "\033\143";

    public TerminalPrinter() {
        this(System.out);
    }

    public TerminalPrinter(PrintStream stream) {
        this.out = stream;
    }

    @Override
    public void print(String text) {
        out.print(text);
    }

    @Override
    public void println(String text) {
        out.println(text);
    }

    @Override
    public void clear() {
        print("\033\143");
        out.flush();
    }
}
