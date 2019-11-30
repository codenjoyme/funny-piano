package com.apofig;

import java.util.Arrays;

/**
 * User: sanja
 * Date: 20.01.14
 * Time: 0:21
 */
public class Пауза {
    private static Нота[] тишина = new Нота[]{new Нота(0)};

    public static Звук взять(double длительность) {
        return new Звук(тишина, длительность, 0);
    }

    public static Звук целая() {
        return взять(1.0);
    }

    public static Звук половина() {
        return взять(1.0 / 2);
    }

    public static Звук четверть() {
        return взять(1.0 / 4);
    }

    public static Звук триЧетверти() {
        return взять(3.0 / 4);
    }

    public static Звук восьмая() {
        return взять(1.0 / 8);
    }

    public static Звук шестнадцатая() {
        return взять(1.0 / 16);
    }
}
