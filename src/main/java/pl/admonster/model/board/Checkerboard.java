package pl.admonster.model.board;

import pl.admonster.model.pointee.Pointee;
import pl.admonster.service.Game;
import pl.admonster.model.pointee.StandardPointee;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Checkerboard implements Board {

    final private BoardField[][] fields;
    public Checkerboard() {
        fields = new BoardField[15][15];
        for (int i = 0 ; i < fields.length; i++)
            for (int j = 0; j < fields[0].length; j++) {
                fields[i][j] = new BoardField();
                fields[i][j].setCoordinates(new Point(i, j));
                fields[i][j].getPointeesOn().add(new StandardPointee());
            }
    }

    @Override
    public List<Point> getAdjacentSquaresTo(final Point centralSquare) {
        List<Point> adjacentSquares = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            if (!this.contains(new Point(centralSquare.x + i, 0))) continue;
            for (int j = -1; j <= 1; j++) {
                Point nextAdjacentSquare = new Point(centralSquare.x + i, centralSquare.y + j);
                if (!this.contains(nextAdjacentSquare)) continue;
                if (!centralSquare.equals(nextAdjacentSquare))
                    adjacentSquares.add(nextAdjacentSquare);
            }
        }

        return adjacentSquares;
    }

    @Override
    public boolean contains(final Point newBirdPosition) {
        return newBirdPosition.x >= 0 &
                newBirdPosition.x < fields.length &
                newBirdPosition.y >= 0 &
                newBirdPosition.y < fields[0].length;
    }

    @Override
    public boolean contains(int x, int y) {
        return contains(new Point(x,y));
    }

    @Override
    public BoardField[][] getFields() {
        return fields;
    }

    @Override
    public BoardField getFieldWithCoordinates(Point currentPosition) {
        return Arrays.stream(fields).flatMap(Arrays::stream)
                                    .filter(i -> i.getCoordinates().equals(currentPosition))
                                    .findFirst()
                                    .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void contactWithMovingObject(Game game) {
        Point movingObjectPosition = game.getMovingObject().getCurrentPosition();
        BoardField affected = game.getGameBoard().getFieldWithCoordinates(movingObjectPosition);

        List<Pointee> pointeesLocatedOnAffected = List.copyOf(affected.getPointeesOn());
        for(Pointee singleThing : pointeesLocatedOnAffected)
            singleThing.contactWithMovingObject(game);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(".........................GAMEBOARD..........................");
        result.append(System.getProperty("line.separator"));
        for (BoardField[] row : fields) {
            for (int j = 0; j < fields[0].length; j++) {
                int valueOfPointeesOnField = row[j].getPointeesOn().stream()
                                                   .mapToInt(Pointee::getValue)
                                                   .sum();
                result.append(String.format("%03d", valueOfPointeesOnField));
                result.append(".");
            }

            result.append(System.getProperty("line.separator"));
        }

        return result.toString();
    }
}
