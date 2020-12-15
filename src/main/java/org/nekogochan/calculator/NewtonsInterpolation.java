package org.nekogochan.calculator;

/**
 * Интерполяция методом Ньютона
 * https://en.wikipedia.org/wiki/Newton_polynomial
 */
public class NewtonsInterpolation {

    // размер таблицы
    private int n;
    // набор значений x
    private double[] x;
    // набор значений y, y2, y3 ...
    private double[][] y;

    /**
     * Установка значечий и построение таблицы [][]y
     * @param n - размер
     * @param x - набор x значений
     * @param y - набор Y значений
     */
    public void setData(int n, double[] x, double[] y) {
        this.n = n;
        this.x = x;
        setY(y);
        dividedDiffTable();
    }

    /**
     * Вспомогательная функция для парсинга одномерного массива в двойной
     * @param y
     */
    private void setY(double[] y) {
        double[][] _y = new double[n][n];
        for (int i = 0; i < y.length; i++) {
            _y[i][0] = y[i];
        }
        this.y = _y;
    }

    /**
     * Функция предназначенная для построения таблицы [][]y
     */
    private void dividedDiffTable() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1][i - 1])
                        / (x[j] - x[i + j]);
            }
        }
    }

    /**
     * Расчет значения интерполируемой функции в точке value
     * @param value - значения x интерполируемой функции
     * @return - возвращает значение y для заданного x
     */
    public double interpolate(double value) {

        System.out.println("Ньютон\nТаблица конечных значений:");
        for (int i = 0; i < y.length; i++) {
            System.out.print("x" + (i + 1) + " |\t");
            for (int j = 0; j < y[0].length; j++) {
                System.out.printf("%.2f\t", y[i][j]);
            }
            System.out.println();
        }

        System.out.println("Расчет значения xi, слагаемые до и после умножения");
        System.out.println("(до умножения) : (после умножения)");

        double sum = y[0][0];
        for (int i = 1; i < n; i++) {
            double pro = 1;
            for (int j = 0; j < i; j++) {
                pro *= value - x[j];
                System.out.printf("%.2f\t", value - x[j]);
            }
            System.out.printf("%.2f :\t%.2f\n",y[0][i] , pro * y[0][i]);
            sum += pro * y[0][i];
        }
        return sum;
    }
}
