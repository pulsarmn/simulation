package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Coordinates;

public class Rock extends Entity {

    private static final String DEFAULT_TEXTURE = "\uD83D\uDDFF";

    public Rock(Coordinates coordinates) {
        super(DEFAULT_TEXTURE, coordinates);
    }
}
