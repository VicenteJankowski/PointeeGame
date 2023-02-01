package pl.admonster.model.board;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.admonster.model.pointee.Pointee;
import pl.admonster.model.pointee.StandardPointee;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardFieldTest {

    BoardField boardfield;
    Pointee standardPointee;

    @BeforeEach
    void setUp() {
        boardfield = new BoardField();
        for (int i = 0; i < 10; i++)
            boardfield.addSinglePointee(new StandardPointee());

        standardPointee = new StandardPointee();
    }

    @Test
    void shouldSumValuesOfAllPointeesOnField() {
        int expected = 10 * standardPointee.getValue();
        int actual = boardfield.sumPointeesValues();

        assertEquals(expected, actual);
    }
}