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

//        Шаблон r = Арпеджиатор.get3(E5, H4, Cis5, A4);
        Шаблон r = Арпеджиатор.get3(G5, D5, E5, C5);
//        Шаблон ш = Шаблон.подряд(Доля.половина(Трезвучие.Минорное.get(E5).toArray(new Нота[0]))).потом(Доля.половина(Трезвучие.Мажорное.get(E5).toArray(new Нота[0])));

        синтезатор.звучать(r.повтор(10));
    }
}
