package com.apofig;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 22:05
 */
public class Действие implements Comparable<Действие> {

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
    public int hashCode() {
        return 31 * нота.hashCode() + сила;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Действие)) return false;

        Действие д = (Действие)o;

        return д.cила() == сила && д.нота() == нота;
    }

    @Override
    public String toString() {
        return String.format("[%s!%s]", нота, сила);
    }

    @Override
    public int compareTo(Действие o) {
        int result = нота.compareTo(o.нота);
        if (result == 0) {
            result = сила - o.сила;
        }
        return result;
    }
}
