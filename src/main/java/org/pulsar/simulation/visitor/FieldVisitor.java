package org.pulsar.simulation.visitor;

import org.pulsar.simulation.model.Entity;
import org.pulsar.simulation.model.Coordinates;

public interface FieldVisitor {

    void visit(Coordinates coordinates, Entity entity);
}
