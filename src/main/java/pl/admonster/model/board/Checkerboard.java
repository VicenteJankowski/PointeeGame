package pl.admonster.model.board;

import pl.admonster.utils.RandomGenerator;
import pl.admonster.model.pointee.StandardPointee;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Checkerboard implements Board{

    final private Field[][] fields = new Field[15][15];

    public Checkerboard() {
        for (Field[] row : fields)
            Arrays.fill(row,new StandardPointee());
    }

    @Override
    public void newMovingObjectOnField(final Point movingObjectPosition) {
        List<Point> adjacentSquares = getAdjacentSquaresTo(movingObjectPosition);
        Point wherePointeesWillEscape = adjacentSquares.get(RandomGenerator.generateFromRange(0, adjacentSquares.size() - 1));

        fields[wherePointeesWillEscape.x][wherePointeesWillEscape.y]
                .addAllPointees(fields[movingObjectPosition.x][movingObjectPosition.y].getPointeesOn());

        fields[movingObjectPosition.x][movingObjectPosition.y].removeAllPointees();
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
    public boolean contains(Point newBirdPosition) {
        return newBirdPosition.x >= 0 &
                newBirdPosition.x < fields.length &
                newBirdPosition.y >= 0 &
                newBirdPosition.y < fields[0].length
                ? TRUE : FALSE;
    }

    @Override
    public boolean contains(int x, int y) {
        return contains(new Point(x,y));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Field[] row : fields) {
            for (int j = 0; j < fields[0].length; j++)
                result.append(String.format("%03d", row[j]) + "   ");
            result.append(System.getProperty("line.separator"));
        }

        return result.toString();
    }

}
