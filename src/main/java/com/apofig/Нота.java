package com.apofig;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 23:01
 */
public class Нота {
    private int тональность;

    public Нота(int тональность) {
        this.тональность = тональность;
    }

    public Нота(Нота нота) {
        тональность = нота.тональность();
    }

    public int тональность() {
        return тональность;
    }

    @Override
    public int hashCode() {
        return тональность;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Нота)) {
            return false;
        }

        Нота нота = (Нота) o;

        return нота.тональность == тональность;
    }

    @Override
    public String toString() {
        return String.format("%s", тональность);
    }

    public Нота наОктавуНиже() {
        return new Нота(тональность - 12);
    }

    public Нота наОктавуВыше() {
        return new Нота(тональность + 12);
    }
}
