package org.pulsar.simulation;

public class Health {

    private final int maxAmount;
    private int currentAmount;

    public Health(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Health amount must be greater than zero: %s".formatted(amount));
        }
        this.maxAmount = amount;
        this.currentAmount = amount;
    }

    public void takeDamage(AttackPower attackPower) {
        if (attackPower == null) {
            return;
        }
        currentAmount -= Math.min(currentAmount, attackPower.amount());
    }

    public void increase(int amount) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot increase health of the dead entity");
        }
        if (amount >= 0) {
            currentAmount += Math.min(maxAmount - currentAmount, amount);
        }
    }

    public boolean isEmpty() {
        return currentAmount <= 0;
    }
}
