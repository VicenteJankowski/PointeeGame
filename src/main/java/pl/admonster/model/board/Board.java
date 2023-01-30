package pl.admonster.model.board;

import java.awt.*;
import java.util.List;

public interface Board {

    void newMovingObjectOnField(final Point movingObjectPosition);
    List<Point> getAdjacentSquaresTo(final Point centralSquare);

    boolean contains(Point newBirdPosition);

    boolean contains(int x, int y);

    BoardField[][] getFields();
}
