package com.apofig;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 20:10
 */
public class Доля {
    public static Звук целая(Нота... ноты) {
        return new Звук(ноты, 1.0);
    }

    public static Звук половина(Нота... ноты) {
        return new Звук(ноты, 1.0/2);
    }

    public static Звук четверть(Нота... ноты) {
        return new Звук(ноты, 1.0/4);
    }

    public static Звук восьмая(Нота... ноты) {
        return new Звук(ноты, 1.0/8);
    }

}
