package com.apofig;

import com.apofig.октавы.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.apofig.октавы.ЧетвертаяОктава.*;
import static com.apofig.октавы.ПятаяОктава.*;
import static com.apofig.октавы.ПерваяОктава.*;
import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.ТретьяОктава.*;
import static com.apofig.октавы.МалаяОктава.*;
import static com.apofig.октавы.БольшаяОктава.*;
import static com.apofig.октавы.Субконтроктава.*;
import static com.apofig.октавы.Контроктава.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.fail;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 12:49
 */
public class ОктаваTest {

    @Test
    public void shouldВсеКлавишиИдутПоследовательно() {
        List<Нота> ноты = Arrays.asList(
                C0, Cis0, D0, Dis0, E0, F0, Fis0, G0, Gis0, A0, Ais0, H0,
                C1, Cis1, D1, Dis1, E1, F1, Fis1, G1, Gis1, A1, Ais1, H1,
                C2, Cis2, D2, Dis2, E2, F2, Fis2, G2, Gis2, A2, Ais2, H2,
                C3, Cis3, D3, Dis3, E3, F3, Fis3, G3, Gis3, A3, Ais3, H3,
                C4, Cis4, D4, Dis4, E4, F4, Fis4, G4, Gis4, A4, Ais4, H4,
                C5, Cis5, D5, Dis5, E5, F5, Fis5, G5, Gis5, A5, Ais5, H5,
                C6, Cis6, D6, Dis6, E6, F6, Fis6, G6, Gis6, A6, Ais6, H6,
                C7, Cis7, D7, Dis7, E7, F7, Fis7, G7, Gis7, A7, Ais7, H7,
                C8, Cis8, D8, Dis8, E8, F8, Fis8, G8, Gis8, A8, Ais8, H8);

        assertEquals("[C0(0), Cis0(1), D0(2), Dis0(3), E0(4), F0(5), Fis0(6), G0(7), Gis0(8), A0(9), Ais0(10), H0(11), " +
                "C1(12), Cis1(13), D1(14), Dis1(15), E1(16), F1(17), Fis1(18), G1(19), Gis1(20), A1(21), Ais1(22), H1(23), " +
                "C2(24), Cis2(25), D2(26), Dis2(27), E2(28), F2(29), Fis2(30), G2(31), Gis2(32), A2(33), Ais2(34), H2(35), " +
                "C3(36), Cis3(37), D3(38), Dis3(39), E3(40), F3(41), Fis3(42), G3(43), Gis3(44), A3(45), Ais3(46), H3(47), " +
                "C4(48), Cis4(49), D4(50), Dis4(51), E4(52), F4(53), Fis4(54), G4(55), Gis4(56), A4(57), Ais4(58), H4(59), " +
                "C5(60), Cis5(61), D5(62), Dis5(63), E5(64), F5(65), Fis5(66), G5(67), Gis5(68), A5(69), Ais5(70), H5(71), " +
                "C6(72), Cis6(73), D6(74), Dis6(75), E6(76), F6(77), Fis6(78), G6(79), Gis6(80), A6(81), Ais6(82), H6(83), " +
                "C7(84), Cis7(85), D7(86), Dis7(87), E7(88), F7(89), Fis7(90), G7(91), Gis7(92), A7(93), Ais7(94), H7(95), " +
                "C8(96), Cis8(97), D8(98), Dis8(99), E8(100), F8(101), Fis8(102), G8(103), Gis8(104), A8(105), Ais8(106), H8(107)]", ноты.toString());
    }

    @Test
    public void shouldПолучаюНотуПоСимвольномуПредставлению() {
        List<Нота> ноты = Arrays.asList(
                ПерваяОктава.get().get("C"),
                ПерваяОктава.get().get("Cis"),
                ПерваяОктава.get().get("D"),
                ПерваяОктава.get().get("Dis"),
                ПерваяОктава.get().get("E"),
                ПерваяОктава.get().get("F"),
                ПерваяОктава.get().get("Fis"),
                ПерваяОктава.get().get("G"),
                ПерваяОктава.get().get("Gis"),
                ПерваяОктава.get().get("A"),
                ПерваяОктава.get().get("Ais"),
                ПерваяОктава.get().get("H"));

        assertEquals("[C4(48), Cis4(49), D4(50), Dis4(51), E4(52), F4(53), Fis4(54), G4(55), Gis4(56), A4(57), Ais4(58), H4(59)]", ноты.toString());
    }

    @Test
    public void shouldНотаBиAisОдинаковые() {
        List<Нота> ноты = Arrays.asList(
                ПерваяОктава.get().get("B"),
                ПерваяОктава.get().get("Ais"));

        assertEquals("[Ais4(58), Ais4(58)]", ноты.toString());

        ноты = Arrays.asList(
                Ais0, B0,
                Ais1, B1,
                Ais2, B2,
                Ais3, B3,
                Ais4, B4,
                Ais5, B5,
                Ais6, B6,
                Ais7, B7,
                Ais8, B8);

        assertEquals("[Ais0(10), Ais0(10), " +
                "Ais1(22), Ais1(22), " +
                "Ais2(34), Ais2(34), " +
                "Ais3(46), Ais3(46), " +
                "Ais4(58), Ais4(58), " +
                "Ais5(70), Ais5(70), " +
                "Ais6(82), Ais6(82), " +
                "Ais7(94), Ais7(94), " +
                "Ais8(106), Ais8(106)]", ноты.toString());
    }

    @Test
    public void shouldУEНетДиеза() {
        try {
            ПерваяОктава.get().get("Eis");
            fail();
        } catch (Exception e) {
            assertEquals("У 'Е' нет диеза", e.getMessage());
        }
    }

    @Test
    public void shouldУHНетДиеза() {
        try {
            ПерваяОктава.get().get("His");
            fail();
        } catch (Exception e) {
            assertEquals("У 'Н' нет диеза", e.getMessage());
        }
    }

    @Test
    public void shouldУBНетДиеза() {
        try {
            ПерваяОктава.get().get("Bis");
            fail();
        } catch (Exception e) {
            assertEquals("У 'B' нет диеза", e.getMessage());
        }
    }

    @Test
    public void shouldУBНетДиеза2() {
        try {
            ПерваяОктава.get().get(7, true);
            fail();
        } catch (Exception e) {
            assertEquals("У 'E', 'Н'/'B' нет диезов", e.getMessage());
        }
    }

    @Test
    public void shouldУEНетДиеза2() {
        try {
            ПерваяОктава.get().get(3, true);
            fail();
        } catch (Exception e) {
            assertEquals("У 'E', 'Н'/'B' нет диезов", e.getMessage());
        }
    }

    @Test
    public void shouldОктавыИдутПодряд() {
        assertSame(null, Субконтроктава.get().предыдущая());
        assertSame(Контроктава.get(), Субконтроктава.get().следующая());

        assertSame(Субконтроктава.get(), Контроктава.get().предыдущая());
        assertSame(БольшаяОктава.get(), Контроктава.get().следующая());

        assertSame(Контроктава.get(), БольшаяОктава.get().предыдущая());
        assertSame(МалаяОктава.get(), БольшаяОктава.get().следующая());

        assertSame(БольшаяОктава.get(), МалаяОктава.get().предыдущая());
        assertSame(ПерваяОктава.get(), МалаяОктава.get().следующая());

        assertSame(МалаяОктава.get(), ПерваяОктава.get().предыдущая());
        assertSame(ВтораяОктава.get(), ПерваяОктава.get().следующая());

        assertSame(ПерваяОктава.get(), ВтораяОктава.get().предыдущая());
        assertSame(ТретьяОктава.get(), ВтораяОктава.get().следующая());

        assertSame(ВтораяОктава.get(), ТретьяОктава.get().предыдущая());
        assertSame(ЧетвертаяОктава.get(), ТретьяОктава.get().следующая());

        assertSame(ТретьяОктава.get(), ЧетвертаяОктава.get().предыдущая());
        assertSame(ПятаяОктава.get(), ЧетвертаяОктава.get().следующая());

        assertSame(ЧетвертаяОктава.get(), ПятаяОктава.get().предыдущая());
        assertSame(null, ПятаяОктава.get().следующая());


    }


}
