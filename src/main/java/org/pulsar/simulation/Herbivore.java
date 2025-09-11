package org.pulsar.simulation;

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
