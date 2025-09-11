package org.pulsar.simulation;

public class Predator extends Creature {

    private final AttackPower attackPower;

    private static final String DEFAULT_TEXTURE = "\uD83D\uDC3A";

    public Predator(Coordinates coordinates, Health health, AttackPower attackPower) {
        super(DEFAULT_TEXTURE, coordinates, health);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {
        // TODO
    }

    public AttackPower getAttackPower() {
        return attackPower;
    }
}
