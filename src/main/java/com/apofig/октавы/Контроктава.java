package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class Контроктава extends Октава {

    private static Контроктава instance;

    public static Контроктава get() {
        return (instance != null) ? instance : new Контроктава();
    }

    public static Нота C1 = Контроктава.нота(1);
    public static Нота D1 = Контроктава.нота(2);
    public static Нота E1 = Контроктава.нота(3);
    public static Нота F1 = Контроктава.нота(4);
    public static Нота G1 = Контроктава.нота(5);
    public static Нота A1 = Контроктава.нота(6);
    public static Нота H1 = Контроктава.нота(7);

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    public Контроктава() {
        instance = this;
        init(Субконтроктава.get(), БольшаяОктава.get(), 12, 14, 16, 17, 19, 21, 23);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
