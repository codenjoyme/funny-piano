package com.apofig;

import org.junit.Test;

import java.util.List;

import static com.apofig.октавы.ПерваяОктава.C4;
import static org.junit.Assert.assertEquals;

public class ОбращениеTest {

    @Test
    public void обращениеВверх() {
        List<Нота> аккорд = Трезвучие.Мажорное.get(C4);

        assertEquals("[C4(48), E4(52), G4(55)]", аккорд.toString());
        assertEquals("[E4(52), G4(55), C5(60)]", Обращение.вверх(аккорд).toString());
        assertEquals("[G4(55), C5(60), E5(64)]", Обращение.вверх(Обращение.вверх(аккорд)).toString());
    }

    @Test
    public void обращениеВниз() {
        List<Нота> аккорд = Трезвучие.Мажорное.get(C4);

        assertEquals("[C4(48), E4(52), G4(55)]", аккорд.toString());
        assertEquals("[G3(43), C4(48), E4(52)]", Обращение.вниз(аккорд).toString());
        assertEquals("[E3(40), G3(43), C4(48)]", Обращение.вниз(Обращение.вниз(аккорд)).toString());
    }
}
