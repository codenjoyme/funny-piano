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
        тональность = нота.частота();
    }

    public int частота() {
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
        return ниже(Интервал.ЧистаяОктава);
    }

    public Нота наОктавуВыше() {
        return выше(Интервал.ЧистаяОктава);
    }

    public Нота выше(Интервал интервал) {
        return new Нота(тональность + (int)(2*интервал.интервал()));
    }

    public Нота ниже(Интервал интервал) {
        return new Нота(тональность - (int)(2*интервал.интервал()));
    }

    public Нота наПолтонаНиже() {
        return ниже(Интервал.Полутон);
    }

    public Нота наПолтонаВыше() {
        return выше(Интервал.Полутон);
    }
}
