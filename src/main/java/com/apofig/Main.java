package com.apofig;

import static com.apofig.Тональность.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class Main {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор();

        final int delay = 300;
        int сила = 120;

        синтезатор.звучатьГамму(ДоМажор, delay, сила);
        синтезатор.звучатьГамму(ЛяМажор, delay, сила);
        синтезатор.звучатьГамму(ЛяМинор, delay, сила);
        синтезатор.звучатьГамму(ЛяМинорГармонический, delay, сила);
        синтезатор.звучатьГамму(ЛяМинорМелодический, delay, сила);
    }
}
