package com.apofig.music;

import com.apofig.*;

import static com.apofig.октавы.ВтораяОктава.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class FourChords {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

//        Шаблон r = Арпеджиатор.FourChords.apply(E5, H4, Cis5, A4);
        Шаблон r = Арпеджиатор.FourChords.apply(G5, D5, E5, C5);

        синтезатор.звучать(r.повтор(10));
    }
}
