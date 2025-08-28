package org.pulsar.simulation.model;

import java.util.Random;

public class Ratio {

    private final double lowerBound;
    private final double upperBound;

    private static final Random RANDOM = new Random();

    public Ratio(double lowerBound, double upperBound) {
        if (lowerBound < 0 || upperBound < 0 || lowerBound >= upperBound) {
            throw new IllegalArgumentException("Wrong arguments: lowerbound=%s; upperBound=%s".formatted(lowerBound, upperBound));
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public double getInRange() {
        return RANDOM.nextDouble(lowerBound, upperBound);
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }
}
