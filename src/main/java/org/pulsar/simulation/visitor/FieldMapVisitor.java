package org.pulsar.simulation.visitor;

import org.pulsar.simulation.Coordinates;
import org.pulsar.simulation.entity.Entity;
import org.pulsar.simulation.RenderedElement;


public class FieldMapVisitor implements FieldVisitor {

    private final ResultAccumulator<RenderedElement> resultAccumulator;

    public FieldMapVisitor(ResultAccumulator<RenderedElement> resultAccumulator) {
        this.resultAccumulator = resultAccumulator;
    }

    @Override
    public void visit(Coordinates coordinates, Entity entity) {
        RenderedElement element = new RenderedElement(coordinates.x(), coordinates.y(), entity.getTexture());
        resultAccumulator.add(element);
    }
}
