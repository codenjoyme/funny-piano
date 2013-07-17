package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class ВтораяОктава extends Октава {

    private static ВтораяОктава instance;

    public static ВтораяОктава get() {
        return (instance != null) ? instance : new ВтораяОктава();
    }

    public static Нота C5 = ВтораяОктава.нота(1);
    public static Нота Cd5 = ВтораяОктава.диез(1);
    public static Нота D5 = ВтораяОктава.нота(2);
    public static Нота Dd5 = ВтораяОктава.диез(2);
    public static Нота E5 = ВтораяОктава.нота(3);
    public static Нота F5 = ВтораяОктава.нота(4);
    public static Нота Fd5 = ВтораяОктава.диез(4);
    public static Нота G5 = ВтораяОктава.нота(5);
    public static Нота Gd5 = ВтораяОктава.диез(5);
    public static Нота A5 = ВтораяОктава.нота(6);
    public static Нота Ad5 = ВтораяОктава.диез(6);
    public static Нота B5 = Ad5;
    public static Нота H5 = ВтораяОктава.нота(7);

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true);
    }

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    public ВтораяОктава() {
        instance = this;
        init(ПерваяОктава.get(), ТретьяОктава.get(), 5);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
