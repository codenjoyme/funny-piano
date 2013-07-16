package com.apofig;

import static com.apofig.Интервал.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:44
 */
public enum Тональность {

    ДоМажор(60, Тон, Тон, Полутон, Тон, Тон, Тон, Полутон);

    private int базоваяНота;
    private Интервал[] интервалы;

    private Тональность(int базоваяНота, Интервал... интервалы) {
        this.базоваяНота = базоваяНота;
        this.интервалы = интервалы;
    }

    public int get(int порядок) {
        int интервал = 0;
        for (int index = 0; index < порядок - 1; index++) {
            интервал += интервалы[index].интервал()*2;
        }
        return базоваяНота + интервал;
    }
}
