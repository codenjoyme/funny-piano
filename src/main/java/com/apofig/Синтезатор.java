package com.apofig;

import com.apofig.октавы.Октава;
import com.apofig.октавы.ПерваяОктава;

import javax.sound.midi.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:20
 */
public class Синтезатор {

    private MidiChannel midi;

    public Синтезатор(MidiChannelFactory midiFactory) {
        this.midi = midiFactory.get();
    }

    public void звучать(int нота, int длительность, int сила) {
        midi.noteOn(нота, сила);
        пауза(длительность);
        midi.noteOff(нота);
        пауза(длительность);
    }

    public void звучатьГамму(Октава октава, Тональность тональность, int длительность, int сила) {
        for (int index = 1; index <= 8; index++) {
            звучать(тональность.get(октава, index), длительность, сила);
        }
    }

    private void пауза(int длительность)  {
        try {
            Thread.sleep(длительность);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
