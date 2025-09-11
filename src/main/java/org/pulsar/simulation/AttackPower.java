package org.pulsar.simulation;

public record AttackPower(int amount) {

    public AttackPower {
        if (amount <= 0) {
            throw new IllegalArgumentException("Attack power must be greater than zero: %s".formatted(amount));
        }
    }
}
