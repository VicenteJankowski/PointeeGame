package pl.admonster.model.board;

import pl.admonster.model.pointee.Pointee;

import java.util.List;

public class Field {
    private List<Pointee> pointeesOn;

    public Field addSinglePointee(Pointee newPointee) {
        pointeesOn.add(newPointee);
        return this;
    }

    public Field addAllPointees(List<Pointee> newPointees) {
        pointeesOn.addAll(newPointees);
        return this;
    }

    public List<Pointee> getPointeesOn() {
        return pointeesOn;
    }

    public Field removeAllPointees() {
        pointeesOn.removeAll(pointeesOn);
        return this;
    }
}
