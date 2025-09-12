package org.pulsar.simulation.render;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Entity;
import org.pulsar.simulation.printer.ConsolePrinter;
import org.pulsar.simulation.printer.Printer;

public class ConsoleFieldMapRenderer implements Renderer {

    private final FieldMap fieldMap;
    private final Printer printer;

    private static final String PLACEHOLDER = "\uD83D\uDD32";
    private static final String NEW_LINE = "\n";

    public ConsoleFieldMapRenderer(FieldMap fieldMap) {
        this(fieldMap, new ConsolePrinter());
    }

    public ConsoleFieldMapRenderer(FieldMap fieldMap, Printer printer) {
        this.fieldMap = fieldMap;
        this.printer = printer;
    }

    @Override
    public void render() {
        printer.clear();

        for (int y = 0; y < fieldMap.getHeight(); y++) {
            for (int x = 0; x < fieldMap.getWidth(); x++) {
                Entity entity = fieldMap.get(new Coordinates(x, y));
                performPrint(entity);
            }
            printer.print(NEW_LINE);
        }
    }

    private void performPrint(Entity entity) {
        if (entity == null) {
            printer.print(PLACEHOLDER);
        } else {
            printer.print(entity.toString());
        }
    }
}
