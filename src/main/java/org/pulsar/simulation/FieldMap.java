package org.pulsar.simulation;

import org.pulsar.simulation.model.Entity;
import org.pulsar.simulation.model.Ground;
import org.pulsar.simulation.visitor.FieldVisitor;
import org.pulsar.simulation.model.Coordinates;

import java.util.Random;

public class FieldMap {

    private final int width;
    private final int height;
    private final Entity[][] field;
    private final Random random = new Random(System.currentTimeMillis());

    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 8;
    private static final Entity PLACEHOLDER = new Ground();

    public FieldMap() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public FieldMap(int width, int height) {
        this.width = (width < DEFAULT_WIDTH) ? DEFAULT_WIDTH : width;
        this.height = (height < DEFAULT_HEIGHT) ? DEFAULT_HEIGHT : height;
        this.field = initField();
    }

    private Entity[][] initField() {
        Entity[][] result = new Entity[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result[y][x] = PLACEHOLDER;
            }
        }
        return result;
    }

    public void set(Coordinates coordinates, Entity entity) {
        if (entity == null) {
            // TODO
        }

        int x = coordinates.x();
        int y = coordinates.y();

        if (x < 0 || x > field[0].length) {
            // TODO
        } else if (y < 0 || y > field.length) {
            // TODO - check method
        }

        field[y][x] = entity;
    }

    public Entity get(Coordinates coordinates) {
        int x = coordinates.x();
        int y = coordinates.y();

        if (x < 0 || x > field[0].length) {
            // TODO
        } else if (y < 0 || y > field.length) {
            // TODO - check method
        }

        return field[y][x];
    }

    public void accept(FieldVisitor visitor) {
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                Entity entity = field[y][x];
                visitor.visit(coordinates, entity);
            }
        }
    }

    public int getArea() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                sb.append(field[y][x]);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
