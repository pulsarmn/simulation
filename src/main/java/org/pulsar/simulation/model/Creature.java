package org.pulsar.simulation.model;


public abstract class Creature extends Entity {

    private final Health health;

    public Creature(String texture, Health health) {
        super(texture);
        this.health = health;
    }

    public abstract void makeMove();
}
