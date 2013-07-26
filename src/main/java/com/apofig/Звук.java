package com.apofig;

import java.util.Arrays;
import java.util.List;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 20:10
 */
public class Звук {

    private Нота[] ноты;
    private double доля;
    private int сила = 100;

    public Звук(Нота[] ноты, double доля) {
        this.ноты = ноты;
        this.доля = доля;
    }

    public List<Нота> ноты() {
        return Arrays.asList(ноты);
    }

    public double доля() {
        return доля;
    }

    public Звук изменить(double доля) {
        return new Звук(ноты, this.доля*доля);
    }

    public int сила() {
        return сила;
    }
}
