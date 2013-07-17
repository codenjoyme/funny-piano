package com.apofig;

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

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 12:49
 */
public class ОктаваTest {

    @Test
    public void shouldWorkВсеКлавишиИдутПоследовательно() {
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

        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, " +
                "12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, " +
                "24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, " +
                "36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, " +
                "48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, " +
                "60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, " +
                "72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, " +
                "84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, " +
                "96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107]", ноты.toString());
    }

}
