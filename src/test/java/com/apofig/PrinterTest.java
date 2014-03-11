package com.apofig;

import com.apofig.октавы.ПерваяОктава;
import org.junit.Test;

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
                "C4(48)|+  |\n" +
                "D4(50)| + |\n", string);
    }
}
