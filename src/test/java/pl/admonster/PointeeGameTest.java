package pl.admonster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointeeGameTest {

    @Test
    void mainClassShouldNotThrownAnException() {
        assertDoesNotThrow(PointeeGame::new);
    }
}