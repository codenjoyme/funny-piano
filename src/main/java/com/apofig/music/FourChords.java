package com.apofig.music;

import com.apofig.*;

import static com.apofig.октавы.ВтораяОктава.Cis5;
import static com.apofig.октавы.ВтораяОктава.E5;
import static com.apofig.октавы.ПерваяОктава.A4;
import static com.apofig.октавы.ПерваяОктава.H4;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class FourChords {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        Шаблон r = Арпеджиатор.get3(E5, H4, Cis5, A4);
//        Шаблон r = Арпеджио.get3(G5, D5, E5, C5);

        синтезатор.звучать(r.повтор(10));
    }




}
