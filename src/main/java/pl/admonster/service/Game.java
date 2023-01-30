package pl.admonster.service;

import pl.admonster.model.board.Board;
import pl.admonster.model.board.BoardField;
import pl.admonster.model.movingObject.MovingObject;

import java.awt.*;

import static java.lang.Boolean.FALSE;

public class Game {
    private final Board gameBoard;
    private final MovingObject movingObject;
    private BoardField selectedToRedeem;
    int roundNumber = 1;
    private boolean isFinshed = FALSE;

    public Game(Board gameBoard, MovingObject movingObject) {
        this.gameBoard = gameBoard;
        this.movingObject = movingObject;
    }

    public void playRound(Point startingPoint){
        movingObject.setStartingPosition(startingPoint);
        gameBoard.newMovingObjectOnField(startingPoint);
        while(gameBoard.contains(movingObject.nextPosition()))
            gameBoard.newMovingObjectOnField(movingObject.getCurrentPosition());
    }

    public BoardField getSelectedToRedeem() {
        return selectedToRedeem;
    }

    public Game setSelectedToRedeem(Point typedPoint) {
        selectedToRedeem = new BoardField(typedPoint);
        return this;
    }

    public boolean isNotfinshed() {
        return !isFinshed;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
