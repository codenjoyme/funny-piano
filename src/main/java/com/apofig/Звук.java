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

    public Звук(Нота[] ноты, double доля) {
        this.ноты = ноты;
        this.доля = доля;
    }

    public Шаблон потом(Звук следуюий) {
        return new Шаблон(this, следуюий);
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
}
