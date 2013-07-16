package com.apofig;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class Main {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор();

        final int delay = 300;

        синтезатор.звучать(Тональность.ДоМажор.get(1), delay, 120);
        синтезатор.звучать(Тональность.ДоМажор.get(2), delay, 120);
        синтезатор.звучать(Тональность.ДоМажор.get(3), delay, 120);
        синтезатор.звучать(Тональность.ДоМажор.get(4), delay, 120);
        синтезатор.звучать(Тональность.ДоМажор.get(5), delay, 120);
        синтезатор.звучать(Тональность.ДоМажор.get(6), delay, 120);
        синтезатор.звучать(Тональность.ДоМажор.get(7), delay, 120);
        синтезатор.звучать(Тональность.ДоМажор.get(8), delay, 120);

        синтезатор.звучать(Тональность.ЛяМинор.get(1), delay, 120);
        синтезатор.звучать(Тональность.ЛяМинор.get(2), delay, 120);
        синтезатор.звучать(Тональность.ЛяМинор.get(3), delay, 120);
        синтезатор.звучать(Тональность.ЛяМинор.get(4), delay, 120);
        синтезатор.звучать(Тональность.ЛяМинор.get(5), delay, 120);
        синтезатор.звучать(Тональность.ЛяМинор.get(6), delay, 120);
        синтезатор.звучать(Тональность.ЛяМинор.get(7), delay, 120);
        синтезатор.звучать(Тональность.ЛяМинор.get(8), delay, 120);
    }


}
