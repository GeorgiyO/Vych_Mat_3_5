package org.nekogochan.model;

/**
 * Вспомогтальная структура, описывающая точку x,y
 */
public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("""
                             Point {
                                x = %s,
                                y = %s,
                             }
                             """, x, y);
    }
}