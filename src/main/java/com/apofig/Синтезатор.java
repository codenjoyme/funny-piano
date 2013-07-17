package com.apofig;

import javax.sound.midi.MidiChannel;
import java.util.List;

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

    public void звучать(Нота нота, int сила) {
        midi.noteOn(нота.тональность(), сила);
    }

    public void звучать(Нота отНоты, Тональность тональность, int длительность, int сила) {
        for (int index = 1; index <= 8; index++) {
            звучать(тональность.get(отНоты, index), длительность, сила);
        }
    }

    public void звучать(Нота отНоты, Трезвучие трезвучие, int сила) {
        List<Нота> аккорд = трезвучие.get(отНоты);
        for (Нота нота : аккорд) {
            звучать(нота, сила);
        }
    }

    private void пауза(int длительность) {
        try {
            Thread.sleep(длительность);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
