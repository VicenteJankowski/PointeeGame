package pl.admonster.service;

import pl.admonster.model.board.Board;
import pl.admonster.model.board.BoardField;
import pl.admonster.model.movingObject.MovingObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board gameBoard;
    private final MovingObject movingObject;
    private BoardField selectedToRedeem;
    private int roundNumber = 1;
    private boolean isFinshed = false;
    private boolean isPossibleToFinish = true;

    enum possibleFinishes {
        roundNumber(5, 25, 50, 100);

        private final List<Object> values;
        possibleFinishes(Object firstValue, Object...nextObjects) {
            values = new ArrayList<>();
            Collections.addAll(values, firstValue, nextObjects);
        }

        public boolean equalsToAnyValue(Object o){
            for (Object singleValue : values)
                if (singleValue.equals(o))
                    return true;
            return false;
        }
    }

    public Game(Board gameBoard, MovingObject movingObject) {
        this.gameBoard = gameBoard;
        this.movingObject = movingObject;
    }

    public void playRound(Point startingPoint){
        movingObject.setStartingPosition(startingPoint);
        gameBoard.contactWithMovingObject(this);
        while(gameBoard.contains(movingObject.nextPosition()))
            gameBoard.contactWithMovingObject(this);
        checkIfPossibleToFinish();
        roundNumber++;
    }

    private void checkIfPossibleToFinish() {
        isPossibleToFinish = possibleFinishes.roundNumber.equalsToAnyValue(this.roundNumber);
    }

    public boolean finish() {
        isFinshed = true;
        return true;
    }

    public BoardField getSelectedToRedeem() {
        return selectedToRedeem;
    }

    public Game setSelectedToRedeem(Point typedPoint) {
        for (BoardField[] row : gameBoard.getFields())
            for (BoardField singleField : row)
                if(singleField.getCoordinates().equals(typedPoint))
                    selectedToRedeem = singleField;
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

    public MovingObject getMovingObject() {
        return movingObject;
    }

    public boolean isPossibleToFinish() {
        return isPossibleToFinish;
    }
}
