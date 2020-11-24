package org.nekogochan.table;

import org.nekogochan.model.Point;

import java.util.ArrayList;

public class TableCalculator {

    private double h;
    private Function foo;

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
            Point p = new Point(current, foo.getY(current));
            System.out.println(p);
            table.add(p);
            current += h;
        }
        return table;
    }
}
