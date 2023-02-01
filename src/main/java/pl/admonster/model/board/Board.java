package pl.admonster.model.board;

import pl.admonster.model.movingObject.TriggeredByMovingObject;
import pl.admonster.model.pointee.Pointeeable;

import java.awt.*;
import java.util.List;

public interface Board extends TriggeredByMovingObject, Pointeeable {

    List<Point> getAdjacentSquaresTo(final Point centralSquare);

    boolean contains(Point newBirdPosition);

    boolean contains(int x, int y);

    BoardField[][] getFields();

    BoardField getFieldWithCoordinates(Point currentPosition);
}
