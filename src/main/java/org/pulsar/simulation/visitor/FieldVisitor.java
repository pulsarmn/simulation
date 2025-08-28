package org.pulsar.simulation.visitor;

import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Entity;

public interface FieldVisitor {

    void visit(Coordinates coordinates, Entity entity);
}
