package com.apofig;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 13:24
 */
public class НотаTest {

    @Test
    public void shouldWork() {
        Нота нота = new Нота(120);

        assertEquals(132, нота.наОктавуВыше().частота());
        assertEquals(144, нота.наОктавуВыше(2).частота());
        assertEquals(108,  нота.наОктавуНиже().частота());
        assertEquals(84,  нота.наОктавуНиже(3).частота());
        assertEquals(119, нота.наПолтонаНиже().частота());
        assertEquals(121, нота.наПолтонаВыше().частота());
    }

    @Test
    public void shouldParse() {
        assertEquals("A3(45)", Нота.parse("A3").toString());
        assertEquals("Dis4(51)", Нота.parse("Dis4").toString());
        assertEquals("E4(52)", Нота.parse("E4").toString());
        assertEquals("E4(52)", Нота.parse("QWE(52)").toString());
        assertEquals("Gis6(80)", Нота.parse("(80)").toString());
        // TODO Ges4, As4, Es4, Des4, B4 - научиться распознавать их тоже
    }
}
