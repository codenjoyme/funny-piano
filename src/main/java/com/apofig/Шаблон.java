package com.apofig;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 20:16
 */
public class Шаблон implements Iterable<Шаблон> {

    private List<Звук> звуки = new LinkedList<Звук>();
    private List<Шаблон> шаблоны = new LinkedList<Шаблон>();

    private Шаблон следующий;
    private Шаблон предыдущий;

    public Шаблон(Звук... звуки) {
        this.звуки.addAll(Arrays.asList(звуки));
        шаблоны.add(this);
    }

    public Шаблон потом(Звук следуюий) {
        звуки.add(следуюий);
        return this;
    }

    @Override
    public Iterator<Шаблон> iterator() {
        return шаблоны.iterator();
    }

    public Шаблон вместе(Шаблон шаблон) {
        шаблоны.add(шаблон);
        return this;
    }

    public List<Звук> звуки() {
        return звуки;
    }

    public Шаблон потом(Шаблон следующий) {
        this.следующий = следующий;
        следующий.предыдущий = this;
        return следующий;
    }

    public Шаблон следующий() {
        return следующий;
    }

    public Шаблон предыдущий() {
        return предыдущий;
    }

    public Шаблон сначала() {
        Шаблон шаблон = this;
        while (шаблон.предыдущий() != null) {
            шаблон = шаблон.предыдущий();
        }
        return шаблон;
    }
}
