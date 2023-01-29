package pl.admonster.service;

import pl.admonster.model.board.Checkerboard;
import pl.admonster.model.movingObject.MovingObject;

import java.awt.*;

public class Game {
    private final Checkerboard checkerboard;
    private final MovingObject movingObject;
    int roundNumber = 1;

    public Game(Checkerboard checkerboard, MovingObject movingObject) {
        this.checkerboard = checkerboard;
        this.movingObject = movingObject;
    }

    public void playRound(Point startingPoint){
        movingObject.setStartingPosition(startingPoint);
        checkerboard.newMovingObjectOnField(startingPoint);
        while(checkerboard.contains(movingObject.nextPosition()))
            checkerboard.newMovingObjectOnField(movingObject.getCurrentPosition());
    }
}
