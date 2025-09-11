package org.pulsar.simulation;

public class Tree extends Entity {

    private static final String DEFAULT_TEXTURE = "\uD83C\uDF32";

    public Tree(Coordinates coordinates) {
        super(DEFAULT_TEXTURE, coordinates);
    }
}
