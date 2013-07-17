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
    public static Нота Cd1 = Контроктава.диез(1);
    public static Нота D1 = Контроктава.нота(2);
    public static Нота Dd1 = Контроктава.диез(2);
    public static Нота E1 = Контроктава.нота(3);
    public static Нота F1 = Контроктава.нота(4);
    public static Нота Fd1 = Контроктава.диез(4);
    public static Нота G1 = Контроктава.нота(5);
    public static Нота Gd1 = Контроктава.диез(5);
    public static Нота A1 = Контроктава.нота(6);
    public static Нота Ad1 = Контроктава.диез(6);
    public static Нота B1 = Ad1;
    public static Нота H1 = Контроктава.нота(7);

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true);
    }

    public Контроктава() {
        instance = this;
        init(Субконтроктава.get(), БольшаяОктава.get(), 1);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
