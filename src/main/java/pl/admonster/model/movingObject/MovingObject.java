package pl.admonster.model.movingObject;

import java.awt.*;

public interface MovingObject {

    public Point nextPosition();

    public Point getCurrentPosition();
    public Point setStartingPosition(Point startingPoint);
}
