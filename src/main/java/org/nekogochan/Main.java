package org.nekogochan;

import org.nekogochan.calculator.LagrangeInterpolation;
import org.nekogochan.model.Point;
import org.nekogochan.table.TableCalculator;

import java.util.ArrayList;

public class Main {

    private static final double H = 0.1;

    public static void main(String[] args) {
        double a = 0;
        double b = Math.PI;

        TableCalculator tableCalculator = new TableCalculator();
        tableCalculator.setH(H).setFoo((x) -> Math.sin(2*x - Math.PI/3));

        ArrayList<Point> points = tableCalculator.getTables(a, b);

        System.out.println(LagrangeInterpolation.interpolate(points, 0.4));
    }
}
