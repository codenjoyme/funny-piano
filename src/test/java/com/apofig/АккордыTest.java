package com.apofig;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 11:31
 */
public class АккордыTest {

    @Test
    public void shouldWork() {
        assertEquals("[55, 60, 64]", Аккорды.get("C", 2).toString());
        assertEquals("[52, 55, 60]", Аккорды.get("C", 1).toString());
        assertEquals("[48, 52, 55]", Аккорды.get("C").toString());
        assertEquals("[43, 48, 52]", Аккорды.get("C", -1).toString());
        assertEquals("[[36, 40, 43]", Аккорды.get("C", -2).toString());
    }
}
