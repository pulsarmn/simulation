package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Health;

public class Herbivore extends Creature {

    private static final String HERBIVORE_TEXTURE = "🐑";

    public Herbivore(Health health) {
        super(HERBIVORE_TEXTURE, health);
    }

    @Override
    public void makeMove() {
        // TODO
    }
}
