package com.apofig;

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
    public void should222() {
        Звук l1_16 = Доля.шестнадцатая(Fis4, E5);
        Звук l2_8 = l1_16.увеличить(2);
        Звук l3_16 = Доля.шестнадцатая(Fis4, C5);
        Звук l4_16 = Доля.шестнадцатая(G4, H5, G5);

        Звук r1_16 = Доля.шестнадцатая(D4);
        Звук r2_8 = r1_16.увеличить(2);
        Звук r3_16 = Доля.шестнадцатая(G4);

        Звук r4_16 = Доля.шестнадцатая(G3);

        Шаблон шаблон = Шаблон.подряд(l1_16, l2_8, l2_8, l3_16, l2_8, l4_16).вместе(r1_16, r2_8, r2_8, r1_16, r2_8, r3_16)
                .потом(Пауза.четверть(), r4_16, Пауза.восьмая());

        String string = Printer.toString(шаблон);

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
}
