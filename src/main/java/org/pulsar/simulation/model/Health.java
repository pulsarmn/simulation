package org.pulsar.simulation.model;


public class Health {

    private int amount;

    public Health(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Too little health amount");
        }
        this.amount = amount;
    }
}
