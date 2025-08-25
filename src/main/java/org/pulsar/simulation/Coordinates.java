package org.pulsar.simulation;


public record Coordinates(int x, int y) {

    @Override
    public String toString() {
        return "Coordinates{x=%s; y=%s}".formatted(x, y);
    }
}
