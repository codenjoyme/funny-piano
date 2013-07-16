package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class ПерваяОктава extends Октава {

    private static ПерваяОктава instance;
    public static ПерваяОктава get() {
        return (instance != null)?instance:new ПерваяОктава();
    }

    public static Нота C4 = ПерваяОктава.нота(1);
    public static Нота D4 = ПерваяОктава.нота(2);
    public static Нота E4 = ПерваяОктава.нота(3);
    public static Нота F4 = ПерваяОктава.нота(4);
    public static Нота G4 = ПерваяОктава.нота(5);
    public static Нота A4 = ПерваяОктава.нота(6);
    public static Нота H4 = ПерваяОктава.нота(7);

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    public ПерваяОктава() {
        instance = this;
        init(МалаяОктава.get(), ВтораяОктава.get(), 48, 50, 52, 53, 55, 57, 59);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
