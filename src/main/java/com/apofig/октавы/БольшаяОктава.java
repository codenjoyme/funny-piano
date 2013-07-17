package com.apofig.октавы;

import com.apofig.Нота;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:55
 */
public class БольшаяОктава extends Октава {

    private static БольшаяОктава instance;

    public static БольшаяОктава get() {
        return (instance != null) ? instance : new БольшаяОктава();
    }

    public static Нота C2 = БольшаяОктава.нота(1);
    public static Нота Cd2 = БольшаяОктава.диез(1);
    public static Нота D2 = БольшаяОктава.нота(2);
    public static Нота Dd2 = БольшаяОктава.диез(2);
    public static Нота E2 = БольшаяОктава.нота(3);
    public static Нота F2 = БольшаяОктава.нота(4);
    public static Нота Fd2 = БольшаяОктава.диез(4);
    public static Нота G2 = БольшаяОктава.нота(5);
    public static Нота Gd2 = БольшаяОктава.диез(5);
    public static Нота A2 = БольшаяОктава.нота(6);
    public static Нота Ad2 = БольшаяОктава.диез(6);
    public static Нота B2 = Ad2;
    public static Нота H2 = БольшаяОктава.нота(7);

    private static Нота нота(int номерНоты) {
        return get().get(номерНоты);
    }

    private static Нота диез(int номерНоты) {
        return get().get(номерНоты, true);
    }

    public БольшаяОктава() {
        instance = this;
        init(Контроктава.get(), МалаяОктава.get(), 2);
    }

    @Override
    public Нота база() {
        return get(1);
    }
}
