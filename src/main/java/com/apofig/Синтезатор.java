package com.apofig;

import com.apofig.октавы.Октава;

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

    public void звучать(Нота нота, int длительность, int сила) {
        midi.noteOn(нота.тональность(), сила);
        пауза(длительность);
        midi.noteOff(нота.тональность());
        пауза(длительность);
    }

    public void звучать(Нота нота, Тональность тональность, int длительность, int сила) {
        for (int index = 1; index <= 8; index++) {
            звучать(тональность.get(нота, index), длительность, сила);
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
