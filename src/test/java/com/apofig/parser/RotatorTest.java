package com.apofig.parser;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by indigo on 25.04.2015.
 */
public class RotatorTest {

    @Test
    public void testOneLine() {
        String actual = Rotator.rotate(
                "C\n" +
                "4\n" +
                " \n" +
                " \n" +
                "=\n" +
                "+\n" +
                "|\n" +
                "+\n" +
                " \n" +
                "=\n" +
                " \n" +
                " \n" +
                " \n" +
                " \n" +
                "=\n");
        assertEquals("C4  ║+-+ ║    ║\n", actual);
    }

    @Test
    public void testSeveralLines() {
        String actual = Rotator.rotate(
                "CCD\n" +
                "4i4\n" +
                " s \n" +
                " 4 \n" +
                "===\n" +
                "+ +\n" +
                "| +\n" +
                "+  \n" +
                " + \n" +
                "===\n" +
                " + \n" +
                " |+\n" +
                "  |\n" +
                "  |\n" +
                "===\n");
        assertEquals(
                "C4  ║+-+ ║    ║\n" +
                "Cis4║   +║+-  ║\n" +
                "D4  ║++  ║ +--║\n",
                actual);
    }
}
