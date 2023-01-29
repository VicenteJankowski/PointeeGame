package pl.admonster;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Checkerboard {

    final private int[][] checkerboard = new int[15][15];

    Checkerboard() {
        for (int[] row : checkerboard)
            Arrays.fill(row,1);
    }

    void birdApproachesToField(final Point birdPosition) {
        List<Point> adjacentSquares = getAdjacentSquaresTo(birdPosition);
        Point wherePointeesWillEscape = adjacentSquares.get(RandomGenerator.generateFromRange(0, adjacentSquares.size() - 1));
        checkerboard[wherePointeesWillEscape.x][wherePointeesWillEscape.y] += checkerboard[birdPosition.x][birdPosition.y];
        checkerboard[birdPosition.x][birdPosition.y] = 0;
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

        for (int[] ints : checkerboard) {
            for (int j = 0; j < checkerboard[0].length; j++)
                result.append(String.format("%03d", ints[j]) + "   ");
            result.append(System.getProperty("line.separator"));
        }

        return result.toString();
    }

    public boolean contains(Point newBirdPosition) {
        return newBirdPosition.x >= 0 &
               newBirdPosition.x < checkerboard.length &
               newBirdPosition.y >= 0 &
               newBirdPosition.y < checkerboard[0].length
                ? TRUE : FALSE;
    }

    public boolean contains(int x, int y) {
        return contains(new Point(x,y));
    }
}
