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
    public BoardField(Point coordinates) {
        this.coordinates = coordinates;
        pointeesOn = new ArrayList<>();
    }

    public BoardField addSinglePointee(Pointee newPointee) {
        pointeesOn.add(newPointee);
        return this;
    }

    public BoardField addAllPointees(List<Pointee> newPointees) {
        pointeesOn.addAll(newPointees);
        return this;
    }

    public List<Pointee> getPointeesOn() {
        return pointeesOn;
    }

    public BoardField removeAllPointees() {
        pointeesOn.removeAll(pointeesOn);
        return this;
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
