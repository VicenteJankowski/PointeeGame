package pl.admonster;

import java.awt.*;

public class Bird implements MovingObject {

    Point startingPosition;
    Point currentPosition;

    public Bird(Point startingPosition) {
        this.startingPosition = startingPosition;
        this.currentPosition = startingPosition;
    }
    
    public Point nextPosition(){
        Point newPosition = new Point();
        newPosition.x = currentPosition.x + RandomGenerator.generateFromRange(-1, 1);
        newPosition.y = currentPosition.y + RandomGenerator.generateFromRange(-1, 1);

        if(currentPosition.equals(newPosition))
            return nextPosition();

        return newPosition;
    }


    public void flyOver(Checkerboard checkerboard) {
        currentPosition.setLocation(startingPosition);

        while(checkerboard.contains(currentPosition)) {
            checkerboard.birdApproachesToField(currentPosition);
            System.out.println("Aktualna pozycja ptaka: " + currentPosition);
            currentPosition = nextPosition();
        }

        System.out.println("####Przelot zakończony####");
    }

}
