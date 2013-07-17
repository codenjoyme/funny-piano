package com.apofig;

import com.apofig.октавы.ПерваяОктава;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.sound.midi.MidiChannel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import static com.apofig.октавы.ПерваяОктава.*;
import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.ТретьяОктава.*;
import static com.apofig.октавы.МалаяОктава.*;
import static com.apofig.октавы.БольшаяОктава.*;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 0:01
 */
public class СинтезаторTest {

    private MidiChannel midi;
    private Синтезатор синтезатор;

    @Before
    public void setup() {
        RealMidiChannelFactory factory = mock(RealMidiChannelFactory.class);
        midi = mock(MidiChannel.class);
        when(factory.get()).thenReturn(midi);

        синтезатор = new Синтезатор(factory);
    }

    @Test
    public void shouldPlayДоМажорСПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get("C"), Тональность.Мажор, 1, 120);

        assertPlay(C4, D4, E4, F4, G4, A4, H4, C5);
    }

    private void assertPlay(Нота... expected) {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(midi, times(expected.length)).noteOn(captor.capture(), anyInt());

        LinkedList<Нота> expected1 = new LinkedList<Нота>();
        expected1.addAll(Arrays.asList(expected));
        List<Integer> values = captor.getAllValues();
        List<Нота> actual = new LinkedList<Нота>();
        for (Integer value : values) {
            actual.add(new Нота(value));
        }
        assertEquals(expected1.toString(), actual.toString());
    }

    @Test
    public void shouldPlayЛяМажорСПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get("A"), Тональность.Мажор, 1, 120);

        assertPlay(A4, H4, Cd5, D5, E5, Fd5, Gd5, A5);
    }

    @Test
    public void shouldPlayЛяМинорСПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get("A"), Тональность.Минор, 1, 120);

        assertPlay(A4, H4, C5, D5, E5, F5, G5, A5);
    }

    @Test
    public void shouldPlayМажорныйАккордСПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get("C"), Трезвучие.Мажорное, 120);

        assertPlay(C4, E4, G4);
    }

    @Test
    public void shouldPlayМинорныйАккордCПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get("C"), Трезвучие.Минорное, 120);

        assertPlay(C4, Dd4, G4);
    }
}
