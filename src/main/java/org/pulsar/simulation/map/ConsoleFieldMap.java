package org.pulsar.simulation.map;

import org.pulsar.simulation.exception.InvalidCoordinatesException;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Entity;

public class ConsoleFieldMap implements FieldMap {

    private final int width;
    private final int height;
    private final Entity[][] field;

    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 8;

    public ConsoleFieldMap() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public ConsoleFieldMap(int width, int height) {
        this.width = Math.max(width, DEFAULT_WIDTH);
        this.height = Math.max(height, DEFAULT_HEIGHT);
        field = new Entity[this.height][this.width];
    }

    @Override
    public Entity get(Coordinates coordinates) throws InvalidCoordinatesException {
        if (!isCellValid(coordinates)) {
            throw new InvalidCoordinatesException(coordinates);
        }
        return field[coordinates.y()][coordinates.x()];
    }

    @Override
    public void set(Coordinates coordinates, Entity entity) throws InvalidCoordinatesException {
        if (!isCellValid(coordinates)) {
            throw new InvalidCoordinatesException(coordinates);
        }
        field[coordinates.y()][coordinates.x()] = entity;
    }

    @Override
    public boolean isCellValid(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates must not be null");
        }
        return coordinates.x() >=0 && coordinates.x() < width && coordinates.y() >= 0 && coordinates.y() < height;
    }

    @Override
    public boolean isCellFree(Coordinates coordinates) {
        if (!isCellValid(coordinates)) {
            return false;
        }
        return field[coordinates.y()][coordinates.x()] == null;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
