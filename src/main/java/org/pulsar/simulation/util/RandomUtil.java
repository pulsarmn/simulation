package org.pulsar.simulation.util;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();

    private RandomUtil() {}

    public static int getInRange(int lowerBound, int upperBound) {
        return RANDOM.nextInt(lowerBound, upperBound);
    }

    public static double getInRange(double lowerBound, double upperBound) {
        return RANDOM.nextDouble(lowerBound, upperBound);
    }
}
