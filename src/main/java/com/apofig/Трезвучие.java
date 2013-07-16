package com.apofig;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static com.apofig.Интервал.*;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 0:36
 */
public enum Трезвучие {

    Мажорное(БольшаяТерция, МалаяТерция),
    Минорное(МалаяТерция, БольшаяТерция),
    Уменьшенное(МалаяТерция, МалаяТерция),
    Увеличенное(БольшаяТерция, БольшаяТерция);

    private Интервал[] интервалы;

    private Трезвучие(Интервал... интервалы) {
        this.интервалы = интервалы;
    }

    public List<Нота> get(Нота from) {
        List<Нота> result = new LinkedList<Нота>();

        int sum = 0;
        result.add(new Нота(from));

        for (Интервал i : интервалы) {
            sum += 2*i.интервал();

            result.add(new Нота(from.тональность() + sum));
        }

        return result;
    }
}
