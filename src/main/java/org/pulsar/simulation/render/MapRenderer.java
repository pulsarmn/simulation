package org.pulsar.simulation.render;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.printer.Printer;
import org.pulsar.simulation.visitor.FieldVisitor;
import org.pulsar.simulation.visitor.ResultHolder;

import java.util.List;

public class MapRenderer implements Renderer {

    private final FieldMap map;
    private final FieldVisitor visitor;
    private final ResultHolder<RenderElement> resultHolder;
    private final Printer printer;

    public MapRenderer(FieldMap map, FieldVisitor visitor, ResultHolder<RenderElement> resultHolder, Printer printer) {
        this.map = map;
        this.visitor = visitor;
        this.resultHolder = resultHolder;
        this.printer = printer;
    }

    @Override
    public void render() {
        clearContext();
        map.accept(visitor);

        int previousY = Integer.MIN_VALUE;
        List<RenderElement> elements = resultHolder.getResults();
        for (var elem : elements) {
            if (previousY != elem.coordinates().y()) {
                previousY = elem.coordinates().y();
                printer.print("\n");
            }
            printer.print(elem.texture());
        }
    }

    private void clearContext() {
        printer.clear();
        resultHolder.clear();
    }
}
