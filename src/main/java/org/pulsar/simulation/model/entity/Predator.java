package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.Health;

public class Predator extends Creature {

    private final int attackPower;

    private static final String PREDATOR_TEXTURE = "🐺";

    public Predator(Health health, int attackPower) {
        super(PREDATOR_TEXTURE, health);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {
        // TODO
    }
}
