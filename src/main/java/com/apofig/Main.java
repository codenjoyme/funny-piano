package com.apofig;

import com.apofig.октавы.*;

import static com.apofig.Тональность.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class Main {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        final int delay = 300;
        int сила = 120;

        синтезатор.звучать(ПерваяОктава.get(), ДоМажор, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get(), ЛяМажор, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get(), ЛяМинор, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get(), ЛяМинорГармонический, delay, сила);
//        синтезатор.звучать(ПерваяОктава.get(), ЛяМинорМелодический, delay, сила);
    }
}
