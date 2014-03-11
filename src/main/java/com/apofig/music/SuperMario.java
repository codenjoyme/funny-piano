package com.apofig.music;

import com.apofig.*;

import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.МалаяОктава.*;
import static com.apofig.октавы.ПерваяОктава.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class SuperMario {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        синтезатор.звучать(get1().потом(get2()));
    }

    private static Шаблон get1() {
        Звук l1_16 = Доля.шестнадцатая(Ges4, E5);
        Звук l2_8 = l1_16.увеличить(2);
        Звук l3_16 = Доля.шестнадцатая(Ges4, C5);
        Звук l4_16 = Доля.шестнадцатая(G4, H5, G5);

        Звук r1_16 = Доля.шестнадцатая(D4);
        Звук r2_8 = r1_16.увеличить(2);
        Звук r3_16 = Доля.шестнадцатая(G4);

        Звук r4_16 = Доля.шестнадцатая(G3);

        return Шаблон.подряд(l1_16, l2_8, l2_8, l3_16, l2_8, l4_16).вместе(r1_16, r2_8, r2_8, r1_16, r2_8, r3_16)
                .потом(Пауза.четверть(), r4_16, Пауза.восьмая());
    }


    public static Шаблон get2() {
        Звук l1_16 = Пауза.восьмая();

        return Шаблон.подряд(l1_16);
    }
}
