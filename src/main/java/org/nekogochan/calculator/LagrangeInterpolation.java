package org.nekogochan.calculator;

import org.nekogochan.model.Point;

import java.util.ArrayList;

public class LagrangeInterpolation {

    static public double interpolate(ArrayList<Point> points, double xi) {
        double result = 0;

        for (int i = 0; i < points.size(); i++) {
            double term = points.get(i).y;
            for (int j = 0; j < points.size(); j++) {
                if (j != i)
                    term = term * (xi - points.get(j).x) / (points.get(i).x - points.get(j).x);
            }
            System.out.printf("x: %.2f; y: %.2f; m: %.2f\n", term / points.get(i).y, points.get(i).y, term);
            result += term;
        }
        return result;
    }
}
