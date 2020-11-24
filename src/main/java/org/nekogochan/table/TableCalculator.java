package org.nekogochan.table;

import org.nekogochan.model.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TableCalculator {

    private double h;
    private Function foo;
    private int count;

    private ArrayList<Point> table = new ArrayList<>();

    public TableCalculator setH(double h) {
        this.h = h;
        return this;
    }

    public TableCalculator setFoo(Function foo) {
        this.foo = foo;
        return this;
    }

    public ArrayList<Point> getTables(double min, double max) {
        double current = min;
        while (current < max) {
            table.add(new Point(current, foo.getY(current)));
            current += h;
        }
        return table;
    }

}
