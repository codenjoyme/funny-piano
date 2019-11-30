package com.apofig;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 20:10
 */
public class Длительность {

    public static Звук целая(Нота... ноты) {
        return взять(1.0, ноты);
    }

    public static Звук половина(Нота... ноты) {
        return взять(1.0 / 2, ноты);
    }

    public static Звук взять(double длительность, Нота... ноты) {
        return new Звук(ноты, длительность);
    }

    public static Звук четверть(Нота... ноты) {
        return взять(1.0/4, ноты);
    }

    public static Звук триЧетверти(Нота... ноты) {
        return взять(3.0/4, ноты);
    }

    public static Звук восьмая(Нота... ноты) {
        return взять(1.0/8, ноты);
    }

    public static Звук шестнадцатая(Нота... ноты) {
        return взять(1.0/16, ноты);
    }
}
