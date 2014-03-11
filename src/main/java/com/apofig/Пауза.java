package com.apofig;

import java.util.Arrays;

/**
 * User: sanja
 * Date: 20.01.14
 * Time: 0:21
 */
public class Пауза {
    private static Нота[] тишина = new Нота[]{new Нота(0)};

    public static Звук целая() {
        return new Звук(тишина, 1.0, 0);
    }

    public static Звук половина() {
        return new Звук(тишина, 1.0 / 2, 0);
    }

    public static Звук четверть() {
        return new Звук(тишина, 1.0 / 4, 0);
    }

    public static Звук триЧетверти() {
        return new Звук(тишина, 3.0 / 4, 0);
    }

    public static Звук восьмая() {
        return new Звук(тишина, 1.0 / 8, 0);
    }

    public static Звук шестнадцатая() {
        return new Звук(тишина, 1.0 / 16, 0);
    }
}
