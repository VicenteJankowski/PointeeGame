package org.example;

public class RandomGenerator {

    private RandomGenerator() {}

    public static int generateFromRange(final int minRange, final int maxRange) {
        return minRange + (int) Math.round(Math.random() * (maxRange - minRange));
    }

}
