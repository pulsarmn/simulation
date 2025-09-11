package org.pulsar.simulation;

public abstract class Entity {

    private final String texture;
    private Coordinates coordinates;

    public Entity(String texture, Coordinates coordinates) {
        this.texture = texture;
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates != null) {
            this.coordinates = coordinates;
        }
    }

    @Override
    public String toString() {
        return texture;
    }
}
