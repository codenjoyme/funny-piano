package com.apofig;

import org.junit.Test;

import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.ПерваяОктава.E4;
import static org.junit.Assert.assertEquals;

/**
 * User: sanja
 * Date: 20.01.14
 * Time: 0:40
 */
public class АрпеджиоTest {
    @Test
    public void shouldWork1() {
        assertEquals("{0.0=[[Gis5(68)!100], [H5(71)!100], [C0(0)!0]], " +
                "0.125=[[C0(0)!0], [E5(64)!100]], " +
                "0.25=[[Gis5(68)!0], [H5(71)!0], [Gis5(68)!100], [H5(71)!100]], " +
                "0.375=[[E5(64)!0], [E5(64)!100]], " +
                "0.5=[[Gis5(68)!0], [H5(71)!0], [Gis5(68)!100], [H5(71)!100]], " +
                "0.625=[[E5(64)!0], [E5(64)!100]], " +
                "0.75=[[Gis5(68)!0], [H5(71)!0], [Gis5(68)!100], [H5(71)!100]], " +
                "0.875=[[E5(64)!0], [E5(64)!100]], " +
                "1.0=[[Gis5(68)!0], [H5(71)!0], [E5(64)!0]]}", Арпеджио.get(E5, Gis5, H5).toString());
    }

    @Test
    public void shouldWork2() {
        assertEquals("{0.0=[[E4(52)!100], [E3(40)!100]], " +
                "0.5=[[E4(52)!0], [E3(40)!0], [C0(0)!0]], " +
                "0.75=[[C0(0)!0], [E4(52)!100], [E3(40)!100]], " +
                "1.0=[[E4(52)!0], [E3(40)!0]]}", Арпеджио.get2(E4).toString());
    }
}
