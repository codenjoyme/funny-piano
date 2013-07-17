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
        assertEquals("[55, 60, 64]",  Аккорды.get("C", 2).toString());
        assertEquals("[52, 55, 60]",  Аккорды.get("C", 1).toString());
        assertEquals("[48, 52, 55]",  Аккорды.get("C").toString());
        assertEquals("[43, 48, 52]",  Аккорды.get("C", -1).toString());
        assertEquals("[40, 43, 48]",  Аккорды.get("C", -2).toString());

        assertEquals("[60, 65, 69]",  Аккорды.get("F", 2).toString());
        assertEquals("[57, 60, 65]",  Аккорды.get("F", 1).toString());
        assertEquals("[53, 57, 60]",  Аккорды.get("F").toString());
        assertEquals("[48, 53, 57]",  Аккорды.get("F", -1).toString());
        assertEquals("[45, 48, 53]",  Аккорды.get("F", -2).toString());

        assertEquals("[62, 67, 71]",  Аккорды.get("G", 2).toString());
        assertEquals("[59, 62, 67]",  Аккорды.get("G", 1).toString());
        assertEquals("[55, 59, 62]",  Аккорды.get("G").toString());
        assertEquals("[50, 55, 59]",  Аккорды.get("G", -1).toString());
        assertEquals("[47, 50, 55]",  Аккорды.get("G", -2).toString());
    }
}
