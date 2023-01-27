package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckerboardTest {

    @Test
    void containsReturnFalseWhenXIndexBelowZero() {
        Checkerboard testCheckerboard = new Checkerboard();
        assertFalse(testCheckerboard.contains(-1,1));
    }

    @Test
    void containsReturnFalseWhenXIndexExceedsCheckerboard() {
        Checkerboard testCheckerboard = new Checkerboard();
        assertFalse(testCheckerboard.contains(16,1));
    }

    @Test
    void containsReturnFalseWhenYIndexBelowZero() {
        Checkerboard testCheckerboard = new Checkerboard();
        assertFalse(testCheckerboard.contains(1,-1));
    }

    @Test
    void containsReturnFalseWhenYIndexExceedsCheckerboard() {
        Checkerboard testCheckerboard = new Checkerboard();
        assertFalse(testCheckerboard.contains(1,16));
    }

    @Test
    void containsReturnTrueWhenIndexAreInBoundsOfCheckerboard3x3() {
        Checkerboard testCheckerboard = new Checkerboard();
        assertTrue(testCheckerboard.contains(3,3));
    }

    @Test
    void containsReturnTrueWhenIndexAreInBoundsOfCheckerboard0x3() {
        Checkerboard testCheckerboard = new Checkerboard();
        assertTrue(testCheckerboard.contains(0,14));
    }
}