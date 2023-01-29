package pl.admonster;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Checkerboard {

    final private Fields[][] fields = new Fields[15][15];

    Checkerboard() {
        for (Fields[] row : fields)
            Arrays.fill(row,new StandardPointee());
    }

    void birdApproachesToField(final Point birdPosition) {
        List<Point> adjacentSquares = getAdjacentSquaresTo(birdPosition);
        Point wherePointeesWillEscape = adjacentSquares.get(RandomGenerator.generateFromRange(0, adjacentSquares.size() - 1));
        //fields[wherePointeesWillEscape.x][wherePointeesWillEscape.y] += fields[birdPosition.x][birdPosition.y];
        //fields[birdPosition.x][birdPosition.y] = 0;
    }

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
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Fields[] row : fields) {
            for (int j = 0; j < fields[0].length; j++)
                result.append(String.format("%03d", row[j]) + "   ");
            result.append(System.getProperty("line.separator"));
        }

        return result.toString();
    }

    public boolean contains(Point newBirdPosition) {
        return newBirdPosition.x >= 0 &
               newBirdPosition.x < fields.length &
               newBirdPosition.y >= 0 &
               newBirdPosition.y < fields[0].length
                ? TRUE : FALSE;
    }

    public boolean contains(int x, int y) {
        return contains(new Point(x,y));
    }
}
