package com.apofig;

import com.apofig.music.LetItBe;
import com.apofig.music.SuperMario;
import com.apofig.октавы.ПерваяОктава;
import org.junit.Test;

import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.МалаяОктава.*;
import static com.apofig.октавы.ПерваяОктава.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Sanja on 11.03.14.
 */
public class PrinterTest {

    @Test
    public void should() {
        Звук c = Доля.половина(ПерваяОктава.C4);
        Звук d = Доля.половина(ПерваяОктава.D4);
        Шаблон шаблон = Шаблон.подряд(c).потом(d);

        String string = Printer.toString(шаблон);

        assertEquals(
                "C4(48)   |+ |\n" +
                "D4(50)   | +|\n", string);
    }

    @Test
    public void should2() {
        Звук c = Доля.половина(ПерваяОктава.C4);
        Шаблон шаблон = Шаблон.подряд(c).потом(c);

        String string = Printer.toString(шаблон);

        assertEquals(
                "C4(48)   |++|\n", string);
    }

    @Test
    public void shouldSuperMario() {
        String string = Printer.toString(SuperMario.get1());

        assertEquals(
                "G3(43)   |             +  |\n" +
                "D4(50)   |++ + ++         |\n" +
                "Fis4(54) |++ + ++         |\n" +
                "G4(55)   |        +       |\n" +
                "C5(60)   |     +          |\n" +
                "E5(64)   |++ +  +         |\n" +
                "G5(67)   |        +       |\n" +
                "H5(71)   |        +       |\n", string);
    }


    @Test
    public void shouldLetItBe() {
        String string = Printer.toString(LetItBe.get());

        assertEquals(
                "C3(36)   |+   +       +                                                   +   +       +                   +   +       +   +   +   +   +                                                                                                                                   |\n" +
                "D3(38)   |                                                            +                                                                                                                                                                                                   |\n" +
                "F3(41)   |               +                                +   +                          +                                                                                                                                                                                |\n" +
                "G3(43)   |                +   +       +               +                                   +   +       +                                                                                                                                                                   |\n" +
                "A3(45)   |                                +   +                                                                                                                                                                                                                           |\n" +
                "C4(48)   |                                                                                                                                                                                                                                                +               |\n" +
                "D4(50)   |                                                                                                                                                                                                                                            +                   |\n" +
                "E4(52)   |                                                                                                                                                                                                                                        +       +               |\n" +
                "F4(53)   |                                                +       +                                                                                                                       +       +                                       +           +                   |\n" +
                "G4(55)   |+       +       +       +                   +                   +       +       +       +                                       +       +       +       +                                       +       +       +       +               +                       |\n" +
                "A4(57)   |                                +       +       +       +                                                                                                       +       +       +       +                                       +                               |\n" +
                "H4(59)   |                +       +                                                       +       +                                                       +       +                                                       +       +                                       |\n" +
                "C5(60)   |+       +                       +       +   +                   +       +                       +       +   +   +               +       +                       +       +       +       +       +       +                       +       +   +   +               |\n" +
                "D5(62)   |                +       +                               +                       +       +                   +                                   +       +                                                       +       +                                       |\n" +
                "E5(64)   |+       +                       +       +   +   +               +       +                               +       +               +       + +                     +       +                       +       +                                                       |\n" +
                "F5(65)   |                                                                                                +           +                                                                                                                                                   |\n" +
                "G5(67)   |                                                                                                        +                   + + +   +         +     +                                                                                                           |\n" +
                "A5(69)   |                                                                                                +                                     +                                                                                                                         |\n" +
                "C6(72)   |                                                                                                                                                        +                           + +                                         +                               |\n" +
                "D6(74)   |                                                                                                                                                          +               +   +                                   +         +                                   |\n" +
                "E6(76)   |                                                                                                                                                                + + +                           + +         + +           +                                     |\n" +
                "F6(77)   |                                                                                                                                                                                                      +                                                         |\n", string);
    }
}
