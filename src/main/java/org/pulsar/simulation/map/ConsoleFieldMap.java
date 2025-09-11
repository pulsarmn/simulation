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
        return null;
    }

    @Override
    public void set(Coordinates coordinates, Entity entity) throws InvalidCoordinatesException {

    }

    @Override
    public boolean isCellValid(Coordinates coordinates) {
        return false;
    }

    @Override
    public boolean isCellFree(Coordinates coordinates) {
        return false;
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
