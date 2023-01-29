package pl.admonster;

import java.awt.*;

public class Game {
    private final Checkerboard checkerboard;
    private final Bird bird;
    int roundNumber = 1;

    public Game(Checkerboard checkerboard, Bird bird) {
        this.checkerboard = checkerboard;
        this.bird = bird;
    }

    public void playRound(Point startingPointOfMovingObject){

    }
}
