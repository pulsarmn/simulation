package org.pulsar.simulation.entity;


public abstract class Entity {

    private final String texture;

    public Entity(String texture) {
        this.texture = texture;
    }

    public String getTexture() {
        return texture;
    }

    @Override
    public String toString() {
        return texture;
    }
}
