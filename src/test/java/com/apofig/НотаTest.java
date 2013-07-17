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
        Нота нота = new Нота(20);

        assertEquals(32, нота.наОктавуВыше().частота());
        assertEquals(8,  нота.наОктавуНиже().частота());
        assertEquals(19, нота.наПолтонаНиже().частота());
        assertEquals(21, нота.наПолтонаВыше().частота());
    }
}
