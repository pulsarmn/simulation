package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;

public class Herbivore extends Creature {

    private static final String DEFAULT_TEXTURE = "\uD83D\uDC11";

    public Herbivore(Coordinates coordinates, Health health) {
        super(DEFAULT_TEXTURE, coordinates, health);
    }

    @Override
    public void makeMove() {
        // TODO
    }
}
