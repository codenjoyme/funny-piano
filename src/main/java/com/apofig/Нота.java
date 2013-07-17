package com.apofig;

import java.util.Arrays;

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
        return String.format("%s(%s)", название(частота), частота);
    }

    private String название(int частота) {
        return Arrays.asList(
                "C0", "Cd0", "D0", "Dd0", "E0", "F0", "Fd0", "G0", "Gd0", "A0", "Ad0", "H0",
                "C1", "Cd1", "D1", "Dd1", "E1", "F1", "Fd1", "G1", "Gd1", "A1", "Ad1", "H1",
                "C2", "Cd2", "D2", "Dd2", "E2", "F2", "Fd2", "G2", "Gd2", "A2", "Ad2", "H2",
                "C3", "Cd3", "D3", "Dd3", "E3", "F3", "Fd3", "G3", "Gd3", "A3", "Ad3", "H3",
                "C4", "Cd4", "D4", "Dd4", "E4", "F4", "Fd4", "G4", "Gd4", "A4", "Ad4", "H4",
                "C5", "Cd5", "D5", "Dd5", "E5", "F5", "Fd5", "G5", "Gd5", "A5", "Ad5", "H5",
                "C6", "Cd6", "D6", "Dd6", "E6", "F6", "Fd6", "G6", "Gd6", "A6", "Ad6", "H6",
                "C7", "Cd7", "D7", "Dd7", "E7", "F7", "Fd7", "G7", "Gd7", "A7", "Ad7", "H7",
                "C8", "Cd8", "D8", "Dd8", "E8", "F8", "Fd8", "G8", "Gd8", "A8", "Ad8", "H8").get(частота);
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
