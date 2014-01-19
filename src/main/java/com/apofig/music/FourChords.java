package com.apofig.music;

import com.apofig.RealMidiChannelFactory;
import com.apofig.Арпеджио;
import com.apofig.Синтезатор;
import com.apofig.Шаблон;

import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.МалаяОктава.A3;
import static com.apofig.октавы.МалаяОктава.H3;
import static com.apofig.октавы.ПерваяОктава.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class FourChords {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        Шаблон l1 = Арпеджио.get(E5, Gis5, H5);
        Шаблон l2 = Арпеджио.get(H4, Dis5, Fis5);
        Шаблон l3 = Арпеджио.get(Cis5, E5, Gis5);
        Шаблон l4 = Арпеджио.get(A4, Cis5, E5);

        Шаблон s1 = l1.потом(l2).потом(l3).потом(l4);

        Шаблон r1 = Арпеджио.get2(E4);
        Шаблон r2 = Арпеджио.get2(H3);
        Шаблон r3 = Арпеджио.get2(Cis4);
        Шаблон r4 = Арпеджио.get2(A3);

        Шаблон s2 = r1.потом(r2).потом(r3).потом(r4);

        Шаблон r = s1.вместе(s2);

        синтезатор.звучать(r);
    }


}
