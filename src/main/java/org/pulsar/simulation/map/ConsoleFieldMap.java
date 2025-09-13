package org.pulsar.simulation.map;

import org.pulsar.simulation.exception.InvalidCoordinatesException;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Entity;
import org.pulsar.simulation.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

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
    public Coordinates getRandomFreeCoordinates(int maxAttempts) {
        if (maxAttempts <= 0) {
            return null;
        }

        Coordinates randomCoordinates = tryGetRandomFreeCoordinates(maxAttempts);
        if (randomCoordinates != null) {
            return randomCoordinates;
        }

        return tryGetFreeCoordinates();
    }

    private Coordinates tryGetRandomFreeCoordinates(int maxAttempts) {
        for (int i = 0; i < maxAttempts; i++) {
            int randomX = RandomUtil.getInRange(0, width);
            int randomY = RandomUtil.getInRange(0, height);
            Coordinates randomCoordinates = new Coordinates(randomX, randomY);

            if (isCellValid(randomCoordinates) && isCellFree(randomCoordinates)) {
                return randomCoordinates;
            }
        }
        return null;
    }

    private Coordinates tryGetFreeCoordinates() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (isCellValid(coordinates) && isCellFree(coordinates)) {
                    return coordinates;
                }
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Entity> List<T> getAllByType(Class<T> type) {
        if (type == null) {
            return List.of();
        }

        List<T> result = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Entity entity = field[y][x];
                if (entity != null && type.isAssignableFrom(entity.getClass())) {
                    result.add((T) entity);
                }
            }
        }

        return result;
    }

    @Override
    public List<Coordinates> getNeighbours(Coordinates coordinates) {
        if (!isCellValid(coordinates)) {
            return List.of();
        }

        var leftNeighbour = new Coordinates(coordinates.x() - 1, coordinates.y());
        var topNeighbour = new Coordinates(coordinates.x(), coordinates.y() - 1);
        var rightNeighbour = new Coordinates(coordinates.x() + 1, coordinates.y());
        var bottomNeighbour = new Coordinates(coordinates.x(), coordinates.y() + 1);

        return getValidNeighbours(leftNeighbour, topNeighbour, rightNeighbour, bottomNeighbour);
    }

    private List<Coordinates> getValidNeighbours(Coordinates...coordinates) {
        List<Coordinates> neighbours = Arrays.stream(coordinates)
                .filter(this::isCellValid)
                .collect(Collectors.toList());
        Collections.shuffle(neighbours);

        return neighbours;
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
