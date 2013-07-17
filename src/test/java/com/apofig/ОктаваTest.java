package com.apofig;

import com.apofig.октавы.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
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
                C0, Cd0, D0, Dd0, E0, F0, Fd0, G0, Gd0, A0, Ad0, H0,
                C1, Cd1, D1, Dd1, E1, F1, Fd1, G1, Gd1, A1, Ad1, H1,
                C2, Cd2, D2, Dd2, E2, F2, Fd2, G2, Gd2, A2, Ad2, H2,
                C3, Cd3, D3, Dd3, E3, F3, Fd3, G3, Gd3, A3, Ad3, H3,
                C4, Cd4, D4, Dd4, E4, F4, Fd4, G4, Gd4, A4, Ad4, H4,
                C5, Cd5, D5, Dd5, E5, F5, Fd5, G5, Gd5, A5, Ad5, H5,
                C6, Cd6, D6, Dd6, E6, F6, Fd6, G6, Gd6, A6, Ad6, H6,
                C7, Cd7, D7, Dd7, E7, F7, Fd7, G7, Gd7, A7, Ad7, H7,
                C8, Cd8, D8, Dd8, E8, F8, Fd8, G8, Gd8, A8, Ad8, H8);

        assertEquals("[C0(0), Cd0(1), D0(2), Dd0(3), E0(4), F0(5), Fd0(6), G0(7), Gd0(8), A0(9), Ad0(10), H0(11), " +
                "C1(12), Cd1(13), D1(14), Dd1(15), E1(16), F1(17), Fd1(18), G1(19), Gd1(20), A1(21), Ad1(22), H1(23), " +
                "C2(24), Cd2(25), D2(26), Dd2(27), E2(28), F2(29), Fd2(30), G2(31), Gd2(32), A2(33), Ad2(34), H2(35), " +
                "C3(36), Cd3(37), D3(38), Dd3(39), E3(40), F3(41), Fd3(42), G3(43), Gd3(44), A3(45), Ad3(46), H3(47), " +
                "C4(48), Cd4(49), D4(50), Dd4(51), E4(52), F4(53), Fd4(54), G4(55), Gd4(56), A4(57), Ad4(58), H4(59), " +
                "C5(60), Cd5(61), D5(62), Dd5(63), E5(64), F5(65), Fd5(66), G5(67), Gd5(68), A5(69), Ad5(70), H5(71), " +
                "C6(72), Cd6(73), D6(74), Dd6(75), E6(76), F6(77), Fd6(78), G6(79), Gd6(80), A6(81), Ad6(82), H6(83), " +
                "C7(84), Cd7(85), D7(86), Dd7(87), E7(88), F7(89), Fd7(90), G7(91), Gd7(92), A7(93), Ad7(94), H7(95), " +
                "C8(96), Cd8(97), D8(98), Dd8(99), E8(100), F8(101), Fd8(102), G8(103), Gd8(104), A8(105), Ad8(106), H8(107)]", ноты.toString());
    }

    @Test
    public void shouldПолучаюНотуПоСимвольномуПредставлению() {
        List<Нота> ноты = Arrays.asList(
                ПерваяОктава.get().get("C"),
                ПерваяОктава.get().get("Cd"),
                ПерваяОктава.get().get("D"),
                ПерваяОктава.get().get("Dd"),
                ПерваяОктава.get().get("E"),
                ПерваяОктава.get().get("F"),
                ПерваяОктава.get().get("Fd"),
                ПерваяОктава.get().get("G"),
                ПерваяОктава.get().get("Gd"),
                ПерваяОктава.get().get("A"),
                ПерваяОктава.get().get("Ad"),
                ПерваяОктава.get().get("H"));

        assertEquals("[C4(48), Cd4(49), D4(50), Dd4(51), E4(52), F4(53), Fd4(54), G4(55), Gd4(56), A4(57), Ad4(58), H4(59)]", ноты.toString());
    }

    @Test
    public void shouldНотаHиBОдинаковые() {
        List<Нота> ноты = Arrays.asList(
                ПерваяОктава.get().get("B"),
                ПерваяОктава.get().get("H"));

        assertEquals("[H4(59), H4(59)]", ноты.toString());

        ноты = Arrays.asList(
                H0, B0,
                H1, B1,
                H2, B2,
                H3, B3,
                H4, B4,
                H5, B5,
                H6, H6,
                H7, H7,
                H8, B8);

        assertEquals("[H0(11), H0(11), " +
                "H1(23), H1(23), " +
                "H2(35), H2(35), " +
                "H3(47), H3(47), " +
                "H4(59), H4(59), " +
                "H5(71), H5(71), " +
                "H6(83), H6(83), " +
                "H7(95), H7(95), " +
                "H8(107), H8(107)]", ноты.toString());
    }

    @Test
    public void shouldУEНетДиеза() {
        try {
            ПерваяОктава.get().get("Ed");
            fail();
        } catch (Exception e) {
            assertEquals("У 'Е' нет диеза", e.getMessage());
        }
    }

    @Test
    public void shouldУHНетДиеза() {
        try {
            ПерваяОктава.get().get("Hd");
            fail();
        } catch (Exception e) {
            assertEquals("У 'Н' нет диеза", e.getMessage());
        }
    }

    @Test
    public void shouldУBНетДиеза() {
        try {
            ПерваяОктава.get().get("Bd");
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
