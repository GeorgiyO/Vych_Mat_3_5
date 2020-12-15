package org.nekogochan;

import org.nekogochan.calculator.LagrangeInterpolation;
import org.nekogochan.calculator.NewtonsInterpolation;
import org.nekogochan.model.Point;
import org.nekogochan.table.TableCalculator;

import java.util.ArrayList;

public class Main {

    /**
     * Точка входа в программу
     * @param args = null
     */
    public static void main(String[] args) {
        double a = 0;
        double b = 3;
        double h = 0.75;
        double xi = 1.35;

        TableCalculator tableCalculator = new TableCalculator();
        tableCalculator.setH(h).setFoo((x) -> Math.log(2*x + 1) + 2 * Math.sin(3 * x));

        ArrayList<Point> points = tableCalculator.getTables(a, b);

        double[] x = new double[points.size()];
        double[] y = new double[points.size()];
        for (int i = 0; i < x.length; i++) {
            x[i] = points.get(i).x;
            y[i] = points.get(i).y;
        }
        NewtonsInterpolation newtonsInterpolation = new NewtonsInterpolation();
        newtonsInterpolation.setData(x.length, x, y);

        System.out.printf("a = %s, b = %s, h = %s, xi = %s\n", a, b, h, xi);
        System.out.printf("LagrangeInterpolation.interpolate result: %.2f\n", LagrangeInterpolation.interpolate(points, xi));
        System.out.printf("NewtonsInterpolation.interpolate result: %.2f\n", newtonsInterpolation.interpolate(xi));
    }
}
