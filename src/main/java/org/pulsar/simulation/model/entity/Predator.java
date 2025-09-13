package org.pulsar.simulation.model.entity;

import org.pulsar.simulation.model.AttackPower;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;
import org.pulsar.simulation.strategy.MoveStrategy;
import org.pulsar.simulation.strategy.PredatorMoveStrategy;

public class Predator extends Creature {

    private final AttackPower attackPower;

    private static final String DEFAULT_TEXTURE = "\uD83D\uDC3A";

    public Predator(Coordinates coordinates, Health health, AttackPower attackPower, MoveStrategy moveStrategy) {
        super(DEFAULT_TEXTURE, coordinates, health, moveStrategy);
        this.attackPower = attackPower;
    }

    public AttackPower getAttackPower() {
        return attackPower;
    }
}
