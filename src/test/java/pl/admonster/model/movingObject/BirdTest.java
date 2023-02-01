package pl.admonster.model.movingObject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {

    MovingObject bird;
    @BeforeEach
    void setUp() {
        bird = new Bird();
        bird.setStartingPosition(new Point(0,0));
    }

    @Test
    void nextPositionShouldReturnPoint() {
        bird.nextPosition();
        assertEquals(bird.getCurrentPosition().getClass(), Point.class);
    }

    @Test
    void currentPositionShouldChangeAfterInvokingNextPositionMethod() {
        Point oldPosition = bird.getCurrentPosition();
        bird.nextPosition();
        Point newPosition = bird.getCurrentPosition();

        assertNotEquals(oldPosition, newPosition);
    }

    @Test
    void setStartingPosition() {
    }
}