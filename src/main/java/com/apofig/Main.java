package com.apofig;

import com.apofig.октавы.*;

import static com.apofig.Тональность.*;
import static com.apofig.Трезвучие.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class Main {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        final int delay = 300;
        int сила = 80;

//        синтезатор.звучать(ПерваяОктава.get().get('C'), Мажор, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get().get('A'), Мажор, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get().get('A'), Минор, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get().get('A'), МинорГармонический, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get().get('A'), МинорМелодический, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get().get('C'), Мажорное, сила);
        синтезатор.звучать(ПерваяОктава.get().get('C'), Минорное, 120);
    }
}
