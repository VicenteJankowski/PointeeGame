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
    int roundNumber = 1;
    private boolean isFinshed = false;
    private boolean isPossibleToFinish = true;

    enum possibleFinishes {
        roundNumber(25, 50, 100);

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
        gameBoard.newMovingObjectOnField(startingPoint);
        while(gameBoard.contains(movingObject.nextPosition()))
            gameBoard.newMovingObjectOnField(movingObject.getCurrentPosition());
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

    public boolean isPossibleToFinish() {
        return isPossibleToFinish;
    }
}
