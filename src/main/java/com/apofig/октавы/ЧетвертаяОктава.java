package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class ЧетвертаяОктава extends Октава {

    private static ЧетвертаяОктава instance;

    public static ЧетвертаяОктава get() {
        return (instance != null) ? instance : new ЧетвертаяОктава();
    }

    public static Нота C7 = ЧетвертаяОктава.нота(1);
    public static Нота Cd7 = ЧетвертаяОктава.диез(1);
    public static Нота D7 = ЧетвертаяОктава.нота(2);
    public static Нота Dd7 = ЧетвертаяОктава.диез(2);
    public static Нота E7 = ЧетвертаяОктава.нота(3);
    public static Нота F7 = ЧетвертаяОктава.нота(4);
    public static Нота Fd7 = ЧетвертаяОктава.диез(4);
    public static Нота G7 = ЧетвертаяОктава.нота(5);
    public static Нота Gd7 = ЧетвертаяОктава.диез(5);
    public static Нота A7 = ЧетвертаяОктава.нота(6);
    public static Нота Ad7 = ЧетвертаяОктава.диез(6);
    public static Нота H7 = ЧетвертаяОктава.нота(7);

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true);
    }

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    public ЧетвертаяОктава() {
        instance = this;
        init(ЧетвертаяОктава.get(), ПятаяОктава.get(), 7);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
