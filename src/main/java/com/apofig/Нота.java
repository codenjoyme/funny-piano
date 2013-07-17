package com.apofig;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 23:01
 */
public class Нота {
    private int частота;

    public Нота(int частота) {
        this.частота = частота;
    }

    public Нота(Нота нота) {
        частота = нота.частота();
    }

    public int частота() {
        return частота;
    }

    @Override
    public int hashCode() {
        return частота;
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

        return нота.частота == частота;
    }

    @Override
    public String toString() {
        return String.format("%s", частота);
    }

    public Нота наОктавуНиже() {
        return ниже(Интервал.ЧистаяОктава);
    }

    public Нота наОктавуВыше() {
        return выше(Интервал.ЧистаяОктава);
    }

    public Нота выше(Интервал интервал) {
        return new Нота(частота + интервал.интервал());
    }

    public Нота ниже(Интервал интервал) {
        return new Нота(частота - интервал.интервал());
    }

    public Нота наПолтонаНиже() {
        return ниже(Интервал.Полутон);
    }

    public Нота наПолтонаВыше() {
        return выше(Интервал.Полутон);
    }
}
