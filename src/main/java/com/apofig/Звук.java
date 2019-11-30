package com.apofig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 20:10
 */
public class Звук {

    private Нота[] ноты;
    private double длительность;
    private int сила = 100;

    public Звук(Нота[] ноты, double длительность) {
        this(ноты, длительность, 100);
    }

    public Звук(Нота[] ноты, double длительность, int сила) {
        this.ноты = ноты;
        this.длительность = длительность;
        this.сила = сила;
    }

    public Set<Нота> ноты() {
        return new HashSet<Нота>(Arrays.asList(ноты));
    }

    public double доля() {
        return длительность;
    }

    public Звук увеличить(double доля) {
        return new Звук(ноты, this.длительность *доля);
    }

    public int сила() {
        return сила;
    }
}
