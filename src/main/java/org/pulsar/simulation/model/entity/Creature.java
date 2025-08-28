package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Health;

public abstract class Creature extends Entity {

    private final Health health;

    public Creature(String texture, Health health) {
        super(texture);
        this.health = health;
    }

    public abstract void makeMove();
}
