package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class МалаяОктава extends Октава {

    private static МалаяОктава instance;

    public static МалаяОктава get() {
        return (instance != null) ? instance : new МалаяОктава();
    }

    public static Нота C3 = МалаяОктава.нота(1);
    public static Нота Cd3 = МалаяОктава.диез(1);
    public static Нота D3 = МалаяОктава.нота(2);
    public static Нота Dd3 = МалаяОктава.диез(2);
    public static Нота E3 = МалаяОктава.нота(3);
    public static Нота F3 = МалаяОктава.нота(4);
    public static Нота Fd3 = МалаяОктава.диез(4);
    public static Нота G3 = МалаяОктава.нота(5);
    public static Нота Gd3 = МалаяОктава.диез(5);
    public static Нота A3 = МалаяОктава.нота(6);
    public static Нота Ad3 = МалаяОктава.диез(6);
    public static Нота H3 = МалаяОктава.нота(7);
    public static Нота B3 = МалаяОктава.нота(7);

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true);
    }

    public МалаяОктава() {
        instance = this;
        init(БольшаяОктава.get(), ПерваяОктава.get(), 3);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
