package org.pulsar.simulation.entity;


public abstract class Creature extends Entity {

    public Creature(String texture) {
        super(texture);
    }

    public abstract void makeMove();
}
