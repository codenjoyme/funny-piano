package com.apofig;

import org.junit.Test;
import static org.junit.Assert.*;

import static com.apofig.октавы.ВтораяОктава.E5;
import static com.apofig.октавы.ВтораяОктава.Gis5;
import static com.apofig.октавы.ВтораяОктава.H5;

/**
 * User: sanja
 * Date: 20.01.14
 * Time: 0:40
 */
public class АрпеджиоTest {
    @Test
    public void shouldWork() {
        assertEquals("{0.0=[[E5(64)!100], [Gis5(68)!100], [C0(0)!0]], " +
                "0.125=[[C0(0)!0], [H5(71)!100]], " +
                "0.25=[[E5(64)!0], [Gis5(68)!0], [E5(64)!100], [Gis5(68)!100]], " +
                "0.375=[[H5(71)!0], [H5(71)!100]], " +
                "0.5=[[E5(64)!0], [Gis5(68)!0], [E5(64)!100], [Gis5(68)!100]], " +
                "0.625=[[H5(71)!0], [H5(71)!100]], " +
                "0.75=[[E5(64)!0], [Gis5(68)!0], [E5(64)!100], [Gis5(68)!100]], " +
                "0.875=[[H5(71)!0], [H5(71)!100]], " +
                "1.0=[[E5(64)!0], [Gis5(68)!0], [H5(71)!0]]}", Арпеджио.get(E5, Gis5, H5).toString());
    }
}
