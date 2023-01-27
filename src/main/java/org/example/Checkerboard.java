package org.example;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checkerboard {

    private int[][] checkerboard = new int[15][15];

    Checkerboard() {
        for (int[] row : checkerboard)
            Arrays.fill(row,1);
    }

    void birdApproachesToField(Point birdPosition) {
        List<Point> adjacentSquares = getAdjacentSquaresTo(birdPosition);
        Point wherePointeesWillEscape = adjacentSquares.get(generateRandomValueInRange(0, adjacentSquares.size() - 1));
        checkerboard[wherePointeesWillEscape.x][wherePointeesWillEscape.y] += checkerboard[birdPosition.x][birdPosition.y];
        checkerboard[birdPosition.x][birdPosition.y] = 0;
    }

    private List<Point> getAdjacentSquaresTo(Point centralSquare) {
        List<Point> adjacentSquares = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            if (centralSquare.x + i < 0 || centralSquare.x + i >= checkerboard.length) continue;
            for (int j = -1; j <= 1; j++) {
                if (centralSquare.y + j < 0 || centralSquare.y + j >= checkerboard[0].length) continue;
                Point nextAdjacentSquare = new Point(centralSquare.x + i, centralSquare.y + j);
                if (!centralSquare.equals(nextAdjacentSquare))
                    adjacentSquares.add(nextAdjacentSquare);
            }
        }

        return adjacentSquares;
    }

    private int generateRandomValueInRange(int minRange, int maxRange) {
        return minRange + (int) Math.round(Math.random() * (maxRange - minRange));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < checkerboard.length; i++) {
            for (int j = 0; j < checkerboard[0].length; j++)
                result.append(String.format("%03d", checkerboard[i][j]) + "   ");
            result.append(System.getProperty("line.separator"));
        }

        return result.toString();
    }
}
