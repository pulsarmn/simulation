package org.pulsar.simulation.model;

import org.pulsar.simulation.util.RandomUtil;

public record Ratio(double lowerBound, double upperBound) {

    public Ratio {
        if (lowerBound < 0 || lowerBound > upperBound) {
            throw new IllegalArgumentException("Invalid arguments: lowerBound=%s; upperBound=%s".formatted(lowerBound, upperBound));
        }
    }

    public double getInRange() {
        return RandomUtil.getInRange(lowerBound, upperBound);
    }
}
