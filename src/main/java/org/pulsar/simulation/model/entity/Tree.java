package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Coordinates;

public class Tree extends Entity {

    private static final String DEFAULT_TEXTURE = "\uD83C\uDF32";

    public Tree(Coordinates coordinates) {
        super(DEFAULT_TEXTURE, coordinates);
    }
}
