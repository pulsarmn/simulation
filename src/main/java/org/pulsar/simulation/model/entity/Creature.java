package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;
import org.pulsar.simulation.strategy.MoveStrategy;

public abstract class Creature extends Entity {

    private final Health health;
    private final MoveStrategy moveStrategy;

    public Creature(String texture, Coordinates coordinates, Health health, MoveStrategy moveStrategy) {
        super(texture, coordinates);
        this.health = health;
        this.moveStrategy = moveStrategy;
    }

    public void makeMove() {
        moveStrategy.move(this);
    }

    public boolean isDead() {
        return health.isEmpty();
    }

    public Health getHealth() {
        return health;
    }
}
