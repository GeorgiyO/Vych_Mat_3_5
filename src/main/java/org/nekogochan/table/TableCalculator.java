package org.nekogochan.table;

import org.nekogochan.model.Point;

import java.util.ArrayList;

/**
 * Вспомогательный класс для расчета таблицы x,y по заданной функции и шагу
 */
public class TableCalculator {

    // шаг
    private double h;
    // функция
    private Function foo;
    // итоговая таблица
    private ArrayList<Point> table = new ArrayList<>();

    /**
     * Установка шага
     * @param h - шаг
     * @return - объект, у которого вызывается функция
     */
    public TableCalculator setH(double h) {
        this.h = h;
        return this;
    }

    /**
     * Установка функции
     * @param foo - функция
     * @return - объект, у которого вызывается функция
     */
    public TableCalculator setFoo(Function foo) {
        this.foo = foo;
        return this;
    }

    /**
     * Функция, отвечающая за непосредственное построение таблицы
     * @param min - первое значение отрезка
     * @param max - второе значение отрезка
     * @return - построенная таблица
     */
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
