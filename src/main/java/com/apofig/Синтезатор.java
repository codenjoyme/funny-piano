package com.apofig;

import javax.sound.midi.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:20
 */
public class Синтезатор {

    private MidiChannel synthChannel;

    public Синтезатор() {
        try {
            // init sequencer
            Sequencer sequencer = null;
            sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // init synthesizer
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();

            // get channel for synthesizing: the highest numbered channel.  sets it up
            MidiChannel[] channels = synth.getChannels();
            synthChannel = channels[channels.length - 1];
            synthChannel.programChange(0);
            звучать(Тональность.ДоМажор.get(1), 10, 1);
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void звучать(int нота, int длительность, int сила) {
        synthChannel.noteOn(нота, сила);
        пауза(длительность);
        synthChannel.noteOff(нота);
        пауза(длительность);
    }

    public void звучатьГамму(Тональность тональность, int длительность, int сила) {
        for (int index = 1; index <= 8; index++) {
            звучать(тональность.get(index), длительность, сила);
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
