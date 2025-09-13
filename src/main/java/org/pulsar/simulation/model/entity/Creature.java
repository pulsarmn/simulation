package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;

public abstract class Creature extends Entity {

    private final Health health;

    public Creature(String texture, Coordinates coordinates, Health health) {
        super(texture, coordinates);
        this.health = health;
    }

    public abstract void makeMove();

    public boolean isDead() {
        return health.isEmpty();
    }

    public Health getHealth() {
        return health;
    }
}
