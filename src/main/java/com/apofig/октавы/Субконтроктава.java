package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class Субконтроктава extends Октава {

    private static Субконтроктава instance;

    public static Субконтроктава get() {
        return (instance != null) ? instance : new Субконтроктава();
    }

    public static Нота C0 = Субконтроктава.нота(1);
    public static Нота D0 = Субконтроктава.нота(2);
    public static Нота E0 = Субконтроктава.нота(3);
    public static Нота F0 = Субконтроктава.нота(4);
    public static Нота G0 = Субконтроктава.нота(5);
    public static Нота A0 = Субконтроктава.нота(6);
    public static Нота H0 = Субконтроктава.нота(7);

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    public Субконтроктава() {
        instance = this;
        init(null, Контроктава.get(), 0, 2, 4, 5, 7, 9, 11);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
