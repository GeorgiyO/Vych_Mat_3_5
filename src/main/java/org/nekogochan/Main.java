package org.nekogochan;

import org.nekogochan.calculator.LagrangeInterpolation;
import org.nekogochan.model.Point;
import org.nekogochan.table.TableCalculator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;
        double h = 0.75;
        double xi = 1.35;

        TableCalculator tableCalculator = new TableCalculator();
        tableCalculator.setH(h).setFoo((x) -> Math.sin(2*x - Math.PI/3));

        ArrayList<Point> points = tableCalculator.getTables(a, b);

        System.out.printf("result: %.2f",LagrangeInterpolation.interpolate(points, xi));
    }
}
