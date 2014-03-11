package com.apofig.parser;

import com.apofig.music.LetItBe;
import com.apofig.Доля;
import com.apofig.Звук;
import com.apofig.Пауза;
import com.apofig.Шаблон;
import static com.apofig.октавы.ПерваяОктава.*;
import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.БольшаяОктава.*;
import static com.apofig.октавы.МалаяОктава.*;
import org.junit.Test;

import static com.apofig.parser.PrinterTest.asrtШбл;
import static org.junit.Assert.assertEquals;

/**
 * Created by Sanja on 11.03.14.
 */
public class ParserTest {

    @Test
    public void should() {
        Звук c = Доля.половина(C4);
        Звук d = Доля.половина(D4);
        Шаблон шаблон = Шаблон.подряд(c).потом(d);

        asrtШбл("D4(50)   ║ :+║\n" +
                "C4(48)   ║+: ║\n", шаблон);

        String string = Printer.toString(шаблон);
        Шаблон шаблон2 = Parser.parse(string);

        asrtШбл("D4(50)   ║ :+║\n" +
                "C4(48)   ║+: ║\n", шаблон2);
    }

    @Test
    public void shouldLetItBe() {
        Шаблон шаблон = LetItBe.get();

        String string = Printer.toString(шаблон);
        Шаблон шаблон2 = Parser.parse(string);
        String string2 = Printer.toString(шаблон2);

        assertEquals(string, string2);
    }

    @Test
    public void shouldSuperMario() {
        String source =
                "H5  ║        :+       ║\n" +
                "G5  ║        :+       ║\n" +
                "E5  ║++ +  + :        ║\n" +
                "C5  ║     +  :        ║\n" +
                "G4  ║        :+       ║\n" +
                "Fis4║++ + ++ :        ║\n" +
                "G3  ║        :+       ║\n" +
                "D3  ║++ + ++ :        ║\n" +
                "G2  ║        :     +  ║\n";

        Шаблон шаблон = Parser.parse(source);

        assertEquals("{0.0=[[D3(38)!100], [Fis4(54)!100], [E5(64)!100]],\n" +
                "0.0625=[[D3(38)!0], [D3(38)!100], [Fis4(54)!0], [Fis4(54)!100], [E5(64)!0], [E5(64)!100]],\n" +
                "0.125=[[D3(38)!0], [Fis4(54)!0], [E5(64)!0]],\n" +
                "0.1875=[[D3(38)!100], [Fis4(54)!100], [E5(64)!100]],\n" +
                "0.25=[[D3(38)!0], [Fis4(54)!0], [E5(64)!0]],\n" +
                "0.3125=[[D3(38)!100], [Fis4(54)!100], [C5(60)!100]],\n" +
                "0.375=[[D3(38)!0], [D3(38)!100], [Fis4(54)!0], [Fis4(54)!100], [C5(60)!0], [E5(64)!100]],\n" +
                "0.4375=[[D3(38)!0], [Fis4(54)!0], [E5(64)!0]],\n" +
                "0.5=[[G3(43)!100], [G4(55)!100], [G5(67)!100], [H5(71)!100]],\n" +
                "0.5625=[[G3(43)!0], [G4(55)!0], [G5(67)!0], [H5(71)!0]],\n" +
                "0.8125=[[G2(31)!100]],\n" +
                "0.875=[[G2(31)!0]],\n" +
                "1.0=[[C0(0)!0]]}", шаблон.toString());

        assertEquals(шаблон.toString(), get1().toString().replaceAll("C0\\(0\\)\\!0\\], \\[", ""));
    }

    public static Шаблон get1() {
        Звук l1_16 = Доля.шестнадцатая(Ges4, E5);
        Звук l3_16 = Доля.шестнадцатая(Ges4, C5);
        Звук l4_16 = Доля.шестнадцатая(G4, H5, G5);

        Звук r1_16 = Доля.шестнадцатая(D3);
        Звук r3_16 = Доля.шестнадцатая(G3);

        Звук r4_16 = Доля.шестнадцатая(G2);

        return Шаблон.подряд(l1_16, l1_16, Пауза.шестнадцатая(), l1_16, Пауза.шестнадцатая(), l3_16, l1_16, Пауза.шестнадцатая(), l4_16)
                .вместе(r1_16, r1_16, Пауза.шестнадцатая(), r1_16, Пауза.шестнадцатая(), r1_16, r1_16, Пауза.шестнадцатая(), r3_16)
                .потом(Пауза.четверть(), r4_16, Пауза.восьмая());
    }

}
