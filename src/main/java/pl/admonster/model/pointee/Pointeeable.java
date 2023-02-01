package pl.admonster.model.pointee;

import pl.admonster.model.board.BoardField;

import java.util.List;

public interface Pointeeable {

    Integer getMaxPointeeValuesOnBoard();
    List<BoardField> getBoardFieldsWithMaxPointeeValues();

}
