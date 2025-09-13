package org.pulsar.simulation.map;

import org.pulsar.simulation.exception.InvalidCoordinatesException;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Entity;

import java.util.List;

public interface FieldMap {

    Coordinates getRandomFreeCoordinates(int maxAttempts);

    Entity get(Coordinates coordinates) throws InvalidCoordinatesException;

    void set(Coordinates coordinates, Entity entity) throws InvalidCoordinatesException;

    <T extends Entity> List<T> getAllByType(Class<T> type);

    List<Coordinates> getNeighbours(Coordinates coordinates);

    boolean isCellValid(Coordinates coordinates);

    boolean isCellFree(Coordinates coordinates);

    int getWidth();

    int getHeight();
}
