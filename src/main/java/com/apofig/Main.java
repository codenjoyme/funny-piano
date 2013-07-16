package com.apofig;

import javax.sound.midi.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class Main {

    public static final int Do = 60;

    public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
        // init sequencer
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();

        // init synthesizer
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();

        // get channel for synthesizing: the highest numbered channel.  sets it up
        MidiChannel[] channels = synth.getChannels();
        MidiChannel synthChannel = channels[channels.length - 1];
        synthChannel.programChange(0);

        synthChannel.noteOn(Do, 120);

        Thread.sleep(100);

        synthChannel.noteOff(Do);
    }
}
