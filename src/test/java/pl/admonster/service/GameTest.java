package pl.admonster.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.admonster.model.board.Board;
import pl.admonster.model.board.BoardField;
import pl.admonster.model.board.Checkerboard;
import pl.admonster.model.movingObject.Bird;
import pl.admonster.model.movingObject.MovingObject;

import java.awt.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setUp(){
        Board gameboard = new Checkerboard();
        MovingObject bird = new Bird();
        game = new Game(gameboard, bird);
    }

    @Test
    void shouldIncrementRoundNumberEachTimeRoundIsPlayed() {
        int beforeRoundNumber = game.getRoundNumber();
        game.playRound(new Point(0,0));
        int afterRoundNumber = game.getRoundNumber();
        assertEquals(beforeRoundNumber + 1, afterRoundNumber);
    }

    @Test
    void shouldSelectedToRedeemContainReferenceToCheckerboardField() {
        Point mockTypedPoint = new Point(0,0);
        game.setSelectedToRedeem(mockTypedPoint);
        BoardField expected = Arrays.stream(game.getGameBoard().getFields())
                                    .flatMap(Arrays::stream)
                                    .filter(i -> i.getCoordinates().equals(mockTypedPoint))
                                    .findFirst()
                                    .orElseThrow(NoSuchElementException::new);
        assertTrue(game.getSelectedToRedeem() == expected);
    }
}