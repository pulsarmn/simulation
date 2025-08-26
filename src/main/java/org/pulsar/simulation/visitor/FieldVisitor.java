package org.pulsar.simulation.visitor;

import org.pulsar.simulation.Coordinates;
import org.pulsar.simulation.entity.Entity;

public interface FieldVisitor {

    void visit(Coordinates coordinates, Entity entity);
}
