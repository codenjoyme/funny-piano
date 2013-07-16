package com.apofig;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:36
 */
public enum Интервал {

    ЧистаяПрима(0),
    МалаяСекунда(0.5), Полутон(0.5),
    БольшаяСекунда(1), Тон(1),
    МалаяТерция(1.5),
    БольшаяТерция(2),
    ЧистаяКварта(2.5),
    УвеличеннаяКварта(3), УменьшеннаяКвинта(3),
    ЧистаяКвинта(3.5),
    МалаяСекста(4),
    БольшаяСекста(4.5),
    МалаяСептима(5),
    БольшаяСептима(5.5),
    ЧистаяОктава(6);

    private double интервал;

    private Интервал(double интервал) {
        this.интервал = интервал;
    }

    public double интервал() {
        return интервал;
    }
}
