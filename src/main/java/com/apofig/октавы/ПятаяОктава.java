package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class ПятаяОктава extends Октава {

    private static ПятаяОктава instance;

    public static ПятаяОктава get() {
        return (instance != null) ? instance : new ПятаяОктава();
    }

    public static Нота C8 = ПятаяОктава.нота(1);
    public static Нота Cd8 = ПятаяОктава.диез(1);
    public static Нота D8 = ПятаяОктава.нота(2);
    public static Нота Dd8 = ПятаяОктава.диез(2);
    public static Нота E8 = ПятаяОктава.нота(3);
    public static Нота F8 = ПятаяОктава.нота(4);
    public static Нота Fd8 = ПятаяОктава.диез(4);
    public static Нота G8 = ПятаяОктава.нота(5);
    public static Нота Gd8 = ПятаяОктава.диез(5);
    public static Нота A8 = ПятаяОктава.нота(6);
    public static Нота Ad8 = ПятаяОктава.диез(6);
    public static Нота H8 = ПятаяОктава.нота(7);

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true);
    }

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    public ПятаяОктава() {
        instance = this;
        init(ПятаяОктава.get(), null, 8);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
