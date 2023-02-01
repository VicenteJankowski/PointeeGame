package pl.admonster.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    void shouldGenerateRandomNumberBetweenGivenRange() {
        int minRange = -1;
        int maxRange = 2;
        int actual = RandomGenerator.generateFromRange(-1, 2);

        assertTrue(minRange <= actual && actual <= maxRange);
    }
}