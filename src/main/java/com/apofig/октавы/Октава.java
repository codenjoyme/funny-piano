package com.apofig.октавы;

import com.apofig.Нота;

import java.util.LinkedList;
import java.util.List;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:54
 */
public abstract class Октава {

    private List<Нота> ноты = new LinkedList<Нота>();
    private Октава следующая;
    private Октава предыдущая;

    public void init(Октава предыдущая, Октава следующая, int... ноты) {
        this.следующая = следующая;
        this.предыдущая = предыдущая;
        for (int нота : ноты) {
            this.ноты.add(new Нота(нота));
        }
    }

    public abstract Нота база();

    public Нота get(int номерНоты) {
        return ноты.get(номерНоты - 1);
    }

    public Октава следующая() {
        return следующая;
    }

    public Октава предыдущая() {
        return предыдущая;
    }
}
