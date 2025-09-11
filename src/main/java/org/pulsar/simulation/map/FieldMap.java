package org.pulsar.simulation.map;

import org.pulsar.simulation.exception.InvalidCoordinatesException;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Entity;

public interface FieldMap {

    Entity get(Coordinates coordinates) throws InvalidCoordinatesException;

    void set(Coordinates coordinates, Entity entity) throws InvalidCoordinatesException;

    boolean isCellValid(Coordinates coordinates);

    boolean isCellFree(Coordinates coordinates);

    int getWidth();

    int getHeight();
}
