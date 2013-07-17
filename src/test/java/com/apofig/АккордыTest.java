package com.apofig;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static com.apofig.октавы.ПерваяОктава.*;
import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.ТретьяОктава.*;
import static com.apofig.октавы.МалаяОктава.*;
import static com.apofig.октавы.БольшаяОктава.*;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 11:31
 */
public class АккордыTest {

    @Test
    public void shouldWork() {
        assertАккорд(G4, C5, E5, "C", 2);
        assertАккорд(E4, G4, C5, "C", 1);
        assertАккорд(C4, E4, G4, "C", 0);
        assertАккорд(G3, C4, E4, "C", -1);
        assertАккорд(E3, G3, C4, "C", -2);

        assertАккорд(C5, F5, A5, "F", 2);
        assertАккорд(A4, C5, F5, "F", 1);
        assertАккорд(F4, A4, C5, "F", 0);
        assertАккорд(C4, F4, A4, "F", -1);
        assertАккорд(A3, C4, F4, "F", -2);

        assertАккорд(D5, G5, H5, "G", 2);
        assertАккорд(H4, D5, G5, "G", 1);
        assertАккорд(G4, H4, D5, "G", 0);
        assertАккорд(D4, G4, H4, "G", -1);
        assertАккорд(H3, D4, G4, "G", -2);

        assertАккорд(A4, D5, Fis5, "D", 2);
        assertАккорд(Fis4, A4, D5, "D", 1);
        assertАккорд(D4, Fis4, A4, "D", 0);
        assertАккорд(A3, D4, Fis4, "D", -1);
        assertАккорд(Fis3, A3, D4, "D", -2);

        assertАккорд(E5, A5, Cis6, "A", 2);
        assertАккорд(Cis5, E5, A5, "A", 1);
        assertАккорд(A4, Cis5, E5, "A", 0);
        assertАккорд(E4, A4, Cis5, "A", -1);
        assertАккорд(Cis4, E4, A4, "A", -2);

        assertАккорд(H4, E5, Gis5, "E", 2);
        assertАккорд(Gis4, H4, E5, "E", 1);
        assertАккорд(E4, Gis4, H4, "E", 0);
        assertАккорд(H3, E4, Gis4, "E", -1);
        assertАккорд(Gis3, H3, E4, "E", -2);

        assertАккорд(Fis5, H5, Dis6, "H", 2);
        assertАккорд(Dis5, Fis5, H5, "H", 1);
        assertАккорд(H4, Dis5, Fis5, "H", 0);
        assertАккорд(Fis4, H4, Dis5, "H", -1);
        assertАккорд(Dis4, Fis4, H4, "H", -2);

        assertАккорд(F5, B5, D6, "B", 2);
        assertАккорд(D5, F5, B5, "B", 1);
        assertАккорд(B4, D5, F5, "B", 0);
        assertАккорд(F4, B4, D5, "B", -1);
        assertАккорд(D4, F4, B4, "B", -2);
    }

    private void assertАккорд(Нота нота1, Нота нота2, Нота нота3, String аккорд, int смещение) {
        String expected = String.format("[%s, %s, %s]", нота1, нота2, нота3);
        assertEquals(expected,  Аккорды.get(аккорд, смещение).toString());
    }
}
