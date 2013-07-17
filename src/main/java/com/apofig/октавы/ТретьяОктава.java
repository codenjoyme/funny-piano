package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class ТретьяОктава extends Октава {

    private static ТретьяОктава instance;

    public static ТретьяОктава get() {
        return (instance != null) ? instance : new ТретьяОктава();
    }

    public static Нота C6 = ТретьяОктава.нота(1);
    public static Нота Cd6 = ТретьяОктава.диез(1);
    public static Нота D6 = ТретьяОктава.нота(2);
    public static Нота Dd6 = ТретьяОктава.диез(2);
    public static Нота E6 = ТретьяОктава.нота(3);
    public static Нота F6 = ТретьяОктава.нота(4);
    public static Нота Fd6 = ТретьяОктава.диез(4);
    public static Нота G6 = ТретьяОктава.нота(5);
    public static Нота Gd6 = ТретьяОктава.диез(5);
    public static Нота A6 = ТретьяОктава.нота(6);
    public static Нота Ad6 = ТретьяОктава.диез(6);
    public static Нота H6 = ТретьяОктава.нота(7);

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true);
    }

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    public ТретьяОктава() {
        instance = this;
        init(ТретьяОктава.get(), ЧетвертаяОктава.get(), 6);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
