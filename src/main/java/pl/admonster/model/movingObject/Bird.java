package pl.admonster.model.movingObject;

import pl.admonster.utils.RandomGenerator;

import java.awt.*;

public class Bird implements MovingObject {

    private Point startingPosition;
    private Point currentPosition;

    public Bird() {}
    public Bird(Point startingPosition) {
        this.startingPosition = startingPosition;
        this.currentPosition = startingPosition;
    }

    @Override
    public Point nextPosition(){
        Point newPosition = new Point();
        newPosition.x = currentPosition.x + RandomGenerator.generateFromRange(-1, 1);
        newPosition.y = currentPosition.y + RandomGenerator.generateFromRange(-1, 1);

        if(currentPosition.equals(newPosition))
            return nextPosition();

        currentPosition = newPosition;
        return newPosition;
    }

    @Override
    public Point getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public Point setStartingPosition(Point startingPoint) {
        this.startingPosition = startingPoint;
        currentPosition = startingPosition;
        return startingPosition;
    }
}
