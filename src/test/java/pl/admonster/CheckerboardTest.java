package pl.admonster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.admonster.model.board.Board;
import pl.admonster.model.board.BoardField;
import pl.admonster.model.board.Checkerboard;
import pl.admonster.model.pointee.StandardPointee;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckerboardTest {

    Board testCheckerboard;

    @BeforeEach
    void setUp(){
        testCheckerboard = new Checkerboard();
    }

    @Test
    void containsReturnFalseWhenXIndexBelowZero() {
        assertFalse(testCheckerboard.contains(-1,1));
    }

    @Test
    void containsReturnFalseWhenXIndexExceedsCheckerboard() {
        assertFalse(testCheckerboard.contains(16,1));
    }

    @Test
    void containsReturnFalseWhenYIndexBelowZero() {
        assertFalse(testCheckerboard.contains(1,-1));
    }

    @Test
    void containsReturnFalseWhenYIndexExceedsCheckerboard() {
        assertFalse(testCheckerboard.contains(1,16));
    }

    @Test
    void containsReturnTrueWhenIndexAreInBoundsOfCheckerboard3x3() {
        assertTrue(testCheckerboard.contains(3,3));
    }

    @Test
    void containsReturnTrueWhenIndexAreInBoundsOfCheckerboard0x3() {
        assertTrue(testCheckerboard.contains(0,14));
    }

    @Test
    void shouldReturnAfterInitializationBoardFieldWithMaxPointeeValueEqualSinglePointeeValue() {
        testCheckerboard.getFieldWithCoordinates(new Point(2,2))
                        .getPointeesOn()
                        .add(new StandardPointee());
        List<BoardField> maxValuesBoardFields = testCheckerboard.getBoardFieldsWithMaxPointeeValues();
        BoardField expected = testCheckerboard.getFields()[2][2];
        assertTrue(maxValuesBoardFields.contains(expected));
    }
}