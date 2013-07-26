package com.apofig;

import java.util.*;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 20:16
 */
public class Шаблон {

    private Map<Double, List<Действие>> map = new TreeMap<Double, List<Действие>>();

    public Шаблон(Звук звук) {
        apply(0, звук);
    }

    public static Шаблон подряд(Звук звук) {
        return new Шаблон(звук);
    }

    public Шаблон потом(Звук звук) {
        apply(всего(), звук);
        return this;
    }

    private double всего() {
        double result = 0;
        for (Map.Entry<Double, List<Действие>> entry : map.entrySet()) {
            result = Math.max(result, entry.getKey());
        }
        return result;
    }

    public Шаблон вместе(Шаблон шаблон) {
        apply(0, шаблон);
        return this;
    }

    public Шаблон потом(Шаблон шаблон) {
        apply(всего(), шаблон);
        return this;
    }

    public int тиков() {
        return (int)(всего()/размерТика());
    }

    public List<Действие> get(int тик) {
        List<Действие> list = map.get(размерТика() * тик);
        if (list == null) {
            list = new LinkedList<Действие>();
        }
        return list;
    }

    public double размерТика() {
        double result = всего();
        double last = 0;
        for (Map.Entry<Double, List<Действие>> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                continue;
            }

            result = Math.min(result, entry.getKey() - last);
            last = entry.getKey();
        }
        return result;
    }

    private void apply(double смещение, Шаблон шаблон) {
        for (Map.Entry<Double, List<Действие>> entry : шаблон.map.entrySet()) {
            get(entry.getKey() + смещение).addAll(entry.getValue());
        }
    }

    private void apply(double смещение, Звук звук) {
        List<Нота> ноты = звук.ноты();
        int сила = звук.сила();

        apply(смещение, ноты, сила);
        apply(смещение + звук.доля(), ноты, 0);
    }

    private void apply(double смещение, List<Нота> ноты, int сила) {
        for (Нота нота : ноты) {
            get(смещение).add(new Действие(нота, сила));
        }
    }

    private List<Действие> get(double смещение) {
        if (map.get(смещение) == null) {
            map.put(смещение, new LinkedList<Действие>());
        }
        return map.get(смещение);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
