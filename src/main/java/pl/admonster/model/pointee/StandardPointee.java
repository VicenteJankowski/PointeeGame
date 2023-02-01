package pl.admonster.model.pointee;

import pl.admonster.service.Game;
import pl.admonster.utils.RandomGenerator;

import java.awt.*;
import java.util.List;

public class StandardPointee implements Pointee {
    private final int value = 1;

    @Override
    public int getValue(){
        return value;
    }

    @Override
    public void contactWithMovingObject(final Game game) {
        Point movingObjectPosition = game.getMovingObject().getCurrentPosition();
        List<Point> adjacentSquares = game.getGameBoard()
                                          .getAdjacentSquaresTo(movingObjectPosition);
        Point wherePointeeWillEscape = adjacentSquares.get(
            RandomGenerator.generateFromRange(0, adjacentSquares.size() - 1));

        game.getGameBoard()
            .getFieldWithCoordinates(wherePointeeWillEscape)
            .getPointeesOn().add(this);
        game.getGameBoard()
            .getFieldWithCoordinates(movingObjectPosition)
            .getPointeesOn().remove(this);
    }
}
