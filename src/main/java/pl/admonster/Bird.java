package pl.admonster;

import java.awt.*;

public class Bird {

    Point startingPosition;
    Point currentPosition;

    private Bird() {}

    public static Bird getNew(Point startingPosition) {
        Bird newBird = new Bird();
        newBird.startingPosition = startingPosition;
        newBird.currentPosition = newBird.startingPosition;
        return newBird;
    }
    public void flyOver(Checkerboard checkerboard) {
        currentPosition.setLocation(startingPosition);

        while(checkerboard.contains(currentPosition)) {
            checkerboard.birdApproachesToField(currentPosition);
            System.out.println("Aktualna pozycja ptaka: " + currentPosition);
            currentPosition = findNewPositionOn();
        }

        System.out.println("####Przelot zakończony####");
    }

    private Point findNewPositionOn() {
        Point newPosition = new Point();
        newPosition.x = currentPosition.x + RandomGenerator.generateFromRange(-1, 1);
        newPosition.y = currentPosition.y + RandomGenerator.generateFromRange(-1, 1);

        if(currentPosition.equals(newPosition))
            return findNewPositionOn();

        return newPosition;
    }
}
