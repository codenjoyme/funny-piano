package com.apofig;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 22:05
 */
public class Действие {

    private Нота нота;
    private int сила;

    public Действие(Нота нота, int сила) {
        this.нота = нота;
        this.сила = сила;
    }

    public Нота нота() {
        return нота;
    }

    public int cила() {
        return сила;
    }


    @Override
    public String toString() {
        return String.format("[%s!%s]", нота, сила);
    }
}
