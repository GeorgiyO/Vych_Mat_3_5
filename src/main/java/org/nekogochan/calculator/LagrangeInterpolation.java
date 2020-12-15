package org.nekogochan.calculator;

import org.nekogochan.model.Point;

import java.util.ArrayList;

/**
 * Интерполяция методом Лагранжа
 * https://en.wikipedia.org/wiki/Lagrange_polynomial
 */
public class LagrangeInterpolation {

    /**
     * Единственная функция класса, отвечающая за получение значение Y для интерполируемой функции в точке x на основе таблицы значений x,y
     * @param points - таблица x,y представленная в виде массива экземпляров класса @org.nekogochan.model.Point
     * @param xi - значение x, для которого необходимо найти значение yi
     * @return - значение y для заданного x
     */
    static public double interpolate(ArrayList<Point> points, double xi) {
        double result = 0;

        System.out.println("Лагранж, (до умножения) : (после умножения)");

        for (int i = 0; i < points.size(); i++) {
            double term = points.get(i).y;
            for (int j = 0; j < points.size(); j++) {
                if (j != i) {
                    term = term * (xi - points.get(j).x) / (points.get(i).x - points.get(j).x);
                }
            }
            System.out.printf("%.2f\t%.2f :\t%.2f\n", points.get(i).y, term / points.get(i).y, term);
            result += term;
        }
        System.out.println();
        return result;
    }
}
