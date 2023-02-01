package pl.admonster.model.board;

import pl.admonster.model.pointee.Pointee;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardField {
    private final Point coordinates;
    private final List<Pointee> pointeesOn;

    public BoardField() {
        coordinates = new Point();
        pointeesOn = new ArrayList<>();
    }

    public List<Pointee> getPointeesOn() {
        return pointeesOn;
    }

    public int sumPointeesValues() {
        return pointeesOn.stream().mapToInt(Pointee::getValue).sum();
    }

    public void setCoordinates(Point point) {
        coordinates.setLocation(point);
    }

    public Point getCoordinates() {
        return coordinates;
    }

}
