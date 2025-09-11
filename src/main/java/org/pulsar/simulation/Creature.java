package org.pulsar.simulation;

public abstract class Creature extends Entity {

    private final Health health;

    public Creature(String texture, Coordinates coordinates, Health health) {
        super(texture, coordinates);
        this.health = health;
    }

    public abstract void makeMove();

    public Health getHealth() {
        return health;
    }
}
