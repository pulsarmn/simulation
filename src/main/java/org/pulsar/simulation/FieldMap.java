package org.pulsar.simulation;

import org.pulsar.simulation.entity.Entity;
import org.pulsar.simulation.entity.Ground;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FieldMap {

    private final Map<Coordinates, Entity> field;

    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 8;
    private static final Entity PLACEHOLDER = new Ground();

    public FieldMap() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public FieldMap(int width, int height) {
        width = (width < DEFAULT_WIDTH) ? DEFAULT_WIDTH : width;
        height = (height < DEFAULT_HEIGHT) ? DEFAULT_HEIGHT : height;
        field = new TreeMap<>(Comparator.comparingInt(Coordinates::y).thenComparing(Coordinates::x));
        initMap(width, height);
    }

    private void initMap(int width, int height) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                field.put(coordinates, PLACEHOLDER);
            }
        }
    }

    public void put(Coordinates coordinates, Entity entity) {
        field.put(coordinates, entity);
    }

    public Entity get(Coordinates coordinates) {
        return field.get(coordinates);
    }
}
