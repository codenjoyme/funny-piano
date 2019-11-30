package com.apofig.parser;

import com.apofig.music.LetItBe;
import com.apofig.Длительность;
import com.apofig.Звук;
import com.apofig.Шаблон;
import com.apofig.октавы.ПерваяОктава;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sanja on 11.03.14.
 */
public class PrinterTest {

    @Test
    public void should() {
        Звук c = Длительность.половина(ПерваяОктава.C4);
        Звук d = Длительность.половина(ПерваяОктава.D4);
        Шаблон шаблон = Шаблон.подряд(c).потом(d);

        asrtШбл("D4(50)   ║ :+║\n" +
                "C4(48)   ║+: ║\n", шаблон);
    }

    @Test
    public void should2() {
        Звук c = Длительность.половина(ПерваяОктава.C4);
        Шаблон шаблон = Шаблон.подряд(c).потом(c);

        asrtШбл("C4(48)   ║+:+║\n", шаблон);
    }

    @Test
    public void shouldSuperMario() {
        asrtШбл("H5(71)   ║        :+       ║\n" +
                "G5(67)   ║        :+       ║\n" +
                "E5(64)   ║++ +  + :        ║\n" +
                "C5(60)   ║     +  :        ║\n" +
                "G4(55)   ║        :+       ║\n" +
                "Fis4(54) ║++ + ++ :        ║\n" +
                "G3(43)   ║        :+       ║\n" +
                "D3(38)   ║++ + ++ :        ║\n" +
                "G2(31)   ║        :     +  ║\n", ParserTest.get1());
    }

    public static void asrtШбл(String expected, Шаблон шаблон) {
        String string = Printer.toString(шаблон);
        assertEquals(
                expected, string);
    }

    @Test
    public void shouldLetItBe() {
        asrtШбл("F6(77)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║      +-:----    ║        :        ║        :        ║        :        ║\n" +
                "E6(76)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║+-+-+---:--      ║        :        ║+-+---  :    +-+-║--      :  +-    ║        :        ║        :        ║\n" +
                "D6(74)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :  +-----║        :  +---+-║----    :        ║        :        ║  +-----:--  +---║        :        ║        :        ║\n" +
                "C6(72)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :+-      ║        :        ║    +-+-:--------║        :        ║        :        ║+-------:        ║        :        ║\n" +
                "A5(69)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║+-------:        ║        :        ║      +-:--      ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n" +
                "G5(67)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :+---    ║        :    +-+-║+---+-  :      +-║----+---:        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n" +
                "F5(65)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║+-------:    +---║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n" +
                "E5(64)   ║+-------:+-------║        :        ║+-------:+---+---║+-------:        ║+-------:+-------║        :        ║        :+---    ║+-------:----    ║+-------:+-+---  ║        :        ║+-------:+-------║        :        ║+-------:+-------║        :        ║        :        ║        :        ║\n" +
                "D5(62)   ║        :        ║+-------:+-------║        :        ║        :+-------║        :        ║+-------:+-------║        :    +---║        :        ║        :        ║+-------:+-------║        :        ║        :        ║        :        ║+-------:+-------║        :        ║        :        ║\n" +
                "C5(60)   ║+-------:+-------║        :        ║+-------:+---+---║        :        ║+-------:+-------║        :        ║+-------:+---+---║+-------:----    ║+-------:+-------║        :        ║+-------:+-------║+-------:+-------║+-------:+-------║        :        ║+-------:+---+---║+-------:--------║\n" +
                "H4(59)   ║        :        ║+-------:+-------║        :        ║        :        ║        :        ║+-------:+-------║        :        ║        :        ║        :        ║+-------:+-------║        :        ║        :        ║        :        ║+-------:+-------║        :        ║        :        ║\n" +
                "A4(57)   ║        :        ║        :        ║+-------:+---    ║+-------:+-------║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║+-------:+-------║+-------:+-------║        :        ║        :        ║+-------:        ║        :        ║\n" +
                "G4(55)   ║+-------:+-------║+-------:+-------║        :    +---║        :        ║+-------:+-------║+-------:+-------║        :        ║        :        ║+-------:+-------║+-------:+-------║        :        ║        :        ║+-------:+-------║+-------:+-------║        :+---    ║        :        ║\n" +
                "F4(53)   ║        :        ║        :        ║        :        ║+-------:+-------║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║+-------:+-------║        :        ║        :        ║+-------:    +---║        :        ║\n" +
                "E4(52)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :+---    ║+-------:--------║\n" +
                "D4(50)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :    +---║        :        ║\n" +
                "C4(48)   ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║+-------:--------║\n" +
                "A3(45)   ║        :        ║        :        ║+---+---:----    ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n" +
                "G3(43)   ║        :        ║+---+---:----+---║        :    +---║        :        ║        :        ║+---+---:----+---║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n" +
                "F3(41)   ║        :       +║        :        ║        :        ║+---+---:----    ║        :       +║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n" +
                "D3(38)   ║        :        ║        :        ║        :        ║        :    +---║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n" +
                "C3(36)   ║+---+---:----+-- ║        :        ║        :        ║        :        ║+---+---:----+-- ║        :        ║+---+---:----+---║+---+---:+---+---║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║        :        ║\n", LetItBe.get());
    }
}
