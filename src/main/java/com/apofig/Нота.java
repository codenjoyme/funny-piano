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
                "C0", "Cis0", "D0", "Dis0", "E0", "F0", "Fis0", "G0", "Gis0", "A0", "Ais0", "H0",
                "C1", "Cis1", "D1", "Dis1", "E1", "F1", "Fis1", "G1", "Gis1", "A1", "Ais1", "H1",
                "C2", "Cis2", "D2", "Dis2", "E2", "F2", "Fis2", "G2", "Gis2", "A2", "Ais2", "H2",
                "C3", "Cis3", "D3", "Dis3", "E3", "F3", "Fis3", "G3", "Gis3", "A3", "Ais3", "H3",
                "C4", "Cis4", "D4", "Dis4", "E4", "F4", "Fis4", "G4", "Gis4", "A4", "Ais4", "H4",
                "C5", "Cis5", "D5", "Dis5", "E5", "F5", "Fis5", "G5", "Gis5", "A5", "Ais5", "H5",
                "C6", "Cis6", "D6", "Dis6", "E6", "F6", "Fis6", "G6", "Gis6", "A6", "Ais6", "H6",
                "C7", "Cis7", "D7", "Dis7", "E7", "F7", "Fis7", "G7", "Gis7", "A7", "Ais7", "H7",
                "C8", "Cis8", "D8", "Dis8", "E8", "F8", "Fis8", "G8", "Gis8", "A8", "Ais8", "H8").get(частота);
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
