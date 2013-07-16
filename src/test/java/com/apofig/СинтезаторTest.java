package com.apofig;

import com.apofig.октавы.ПерваяОктава;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.sound.midi.MidiChannel;

import java.util.Arrays;
import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

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
        синтезатор.звучать(ПерваяОктава.get().get('C'), Тональность.Мажор, 1, 120);

        assertPlay(48, 50, 52, 53, 55, 57, 59, 60);
    }

    private void assertPlay(Integer... expected) {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(midi, times(expected.length)).noteOn(captor.capture(), anyInt());

        LinkedList<Integer> expected1 = new LinkedList<Integer>();
        expected1.addAll(Arrays.asList(expected));
        assertEquals(expected1.toString(), captor.getAllValues().toString());
    }

    @Test
    public void shouldPlayЛяМажорСПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get('A'), Тональность.Мажор, 1, 120);

        assertPlay(57, 59, 61, 62, 64, 66, 68, 69);
    }

    @Test
         public void shouldPlayЛяМинорСПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get('A'), Тональность.Минор, 1, 120);

        assertPlay(57, 59, 60, 62, 64, 65, 67, 69);
    }

    @Test
    public void shouldPlayМажорныйАккордСПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get('C'), Трезвучие.Мажорное, 120);

        assertPlay(48, 55, 52);
    }

    @Test
    public void shouldPlayМинорныйАккордCПервойОктавы() {
        синтезатор.звучать(ПерваяОктава.get().get('C'), Трезвучие.Минорное, 120);

        assertPlay(48, 51, 55);
    }
}
