package org.pulsar.simulation.visitor;

import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Entity;
import org.pulsar.simulation.render.RenderElement;

public class FieldMapVisitor implements FieldVisitor {

    private final ResultHolder<RenderElement> resultHolder;

    public FieldMapVisitor(ResultHolder<RenderElement> resultHolder) {
        this.resultHolder = resultHolder;
    }

    @Override
    public void visit(Coordinates coordinates, Entity entity) {
        // TODO - implement a try-catch if an exception is thrown
        resultHolder.add(new RenderElement(coordinates, entity.getTexture()));
    }
}
