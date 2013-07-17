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
        return (instance != null) ? instance : new ПерваяОктава();
    }

    public static Нота C4 = ПерваяОктава.нота(1);
    public static Нота Cis4 = ПерваяОктава.диез(1);
    public static Нота Des4 = Cis4;
    public static Нота D4 = ПерваяОктава.нота(2);
    public static Нота Dis4 = ПерваяОктава.диез(2);
    public static Нота Es4 = Dis4;
    public static Нота E4 = ПерваяОктава.нота(3);
    public static Нота F4 = ПерваяОктава.нота(4);
    public static Нота Fis4 = ПерваяОктава.диез(4);
    public static Нота Ges4 = Fis4;
    public static Нота G4 = ПерваяОктава.нота(5);
    public static Нота Gis4 = ПерваяОктава.диез(5);
    public static Нота As4 = Gis4;
    public static Нота A4 = ПерваяОктава.нота(6);
    public static Нота Ais4 = ПерваяОктава.диез(6);
    public static Нота B4 = Ais4;
    public static Нота H4 = ПерваяОктава.нота(7);

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true, false);
    }

    public ПерваяОктава() {
        instance = this;
        init(МалаяОктава.get(), ВтораяОктава.get(), 4);
    }

}
