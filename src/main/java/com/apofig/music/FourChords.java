package com.apofig.music;

import com.apofig.*;

import static com.apofig.октавы.ВтораяОктава.*;
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

        Шаблон s1 = l1.потом(l2).потом(l3).потом(l4);//.вместе(Шаблон.подряд(r11).потом(r12).потом(r13).потом(r14));

        синтезатор.звучать(s1);
    }


}
