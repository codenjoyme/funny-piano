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

        синтезатор.звучать(ДоМажор.get(1), delay, 120);
        синтезатор.звучать(ДоМажор.get(2), delay, 120);
        синтезатор.звучать(ДоМажор.get(3), delay, 120);
        синтезатор.звучать(ДоМажор.get(4), delay, 120);
        синтезатор.звучать(ДоМажор.get(5), delay, 120);
        синтезатор.звучать(ДоМажор.get(6), delay, 120);
        синтезатор.звучать(ДоМажор.get(7), delay, 120);
        синтезатор.звучать(ДоМажор.get(8), delay, 120);

        синтезатор.звучать(ЛяМажор.get(1), delay, 120);
        синтезатор.звучать(ЛяМажор.get(2), delay, 120);
        синтезатор.звучать(ЛяМажор.get(3), delay, 120);
        синтезатор.звучать(ЛяМажор.get(4), delay, 120);
        синтезатор.звучать(ЛяМажор.get(5), delay, 120);
        синтезатор.звучать(ЛяМажор.get(6), delay, 120);
        синтезатор.звучать(ЛяМажор.get(7), delay, 120);
        синтезатор.звучать(ЛяМажор.get(8), delay, 120);

        синтезатор.звучать(ЛяМинор.get(1), delay, 120);
        синтезатор.звучать(ЛяМинор.get(2), delay, 120);
        синтезатор.звучать(ЛяМинор.get(3), delay, 120);
        синтезатор.звучать(ЛяМинор.get(4), delay, 120);
        синтезатор.звучать(ЛяМинор.get(5), delay, 120);
        синтезатор.звучать(ЛяМинор.get(6), delay, 120);
        синтезатор.звучать(ЛяМинор.get(7), delay, 120);
        синтезатор.звучать(ЛяМинор.get(8), delay, 120);
    }


}
