package com.apofig;

import com.apofig.октавы.ПерваяОктава;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.sound.midi.MidiChannel;

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
        синтезатор.звучатьГамму(ПерваяОктава.get(), Тональность.ДоМажор, 1, 120);

        assertPlay("[48, 50, 52, 53, 55, 57, 59, 60]");
    }

    private void assertPlay(String expected) {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(midi, times(8)).noteOn(captor.capture(), anyInt());

        assertEquals(expected, captor.getAllValues().toString());
    }

    @Test
    public void shouldPlayЛяМажорСПервойОктавы() {
        синтезатор.звучатьГамму(ПерваяОктава.get(), Тональность.ЛяМажор, 1, 120);

        assertPlay("[57, 59, 61, 62, 64, 66, 68, 69]");
    }

    @Test
    public void shouldPlayЛяМинорСПервойОктавы() {
        синтезатор.звучатьГамму(ПерваяОктава.get(), Тональность.ЛяМинор, 1, 120);

        assertPlay("[57, 59, 60, 62, 64, 65, 67, 69]");
    }
}
