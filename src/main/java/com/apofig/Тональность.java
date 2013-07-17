package com.apofig;

import static com.apofig.Интервал.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:44
 */
public enum Тональность {

    Мажор(Тон, Тон, Полутон, Тон, Тон, Тон, Полутон),
    Минор(Тон, Полутон, Тон, Тон, Полутон, Тон, Тон),
    МинорГармонический(Тон, Полутон, Тон, Тон, Полутон, МалаяТерция, Полутон),
    МинорМелодический(Тон, Полутон, Тон, Тон, Тон, Тон, Полутон);

    private Интервал[] интервалы;

    private Тональность(Интервал... интервалы) {
        this.интервалы = интервалы;
    }

    public Нота get(Нота from, int order) {
        int sum = 0;
        for (int index = 0; index < order - 1; index++) {
            sum += 2 * интервал(index);
        }
        return new Нота(from.тональность() + sum);
    }

    private double интервал(int index) {
        index = index % 7;
        return интервалы[index].интервал();
    }
}
