package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Coordinates;

public class Grass extends Entity {

    private static final String DEFAULT_TEXTURE = "\uD83C\uDF3F";

    public Grass(Coordinates coordinates) {
        super(DEFAULT_TEXTURE, coordinates);
    }
}
