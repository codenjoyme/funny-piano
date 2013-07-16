package com.apofig;

import javax.sound.midi.*;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class Main {

    private static MidiChannel synthChannel;

    public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
        // init sequencer
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();

        // init synthesizer
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();

        // get channel for synthesizing: the highest numbered channel.  sets it up
        MidiChannel[] channels = synth.getChannels();
        synthChannel = channels[channels.length - 1];
        synthChannel.programChange(0);
        звучать(Тональность.ДоМажор.get(1), 10, 1);

        final int delay = 300;

        звучать(Тональность.ДоМажор.get(1), delay, 120);
        звучать(Тональность.ДоМажор.get(2), delay, 120);
        звучать(Тональность.ДоМажор.get(3), delay, 120);
        звучать(Тональность.ДоМажор.get(4), delay, 120);
        звучать(Тональность.ДоМажор.get(5), delay, 120);
        звучать(Тональность.ДоМажор.get(6), delay, 120);
        звучать(Тональность.ДоМажор.get(7), delay, 120);
        звучать(Тональность.ДоМажор.get(8), delay, 120);

        звучать(Тональность.ЛяМинор.get(1), delay, 120);
        звучать(Тональность.ЛяМинор.get(2), delay, 120);
        звучать(Тональность.ЛяМинор.get(3), delay, 120);
        звучать(Тональность.ЛяМинор.get(4), delay, 120);
        звучать(Тональность.ЛяМинор.get(5), delay, 120);
        звучать(Тональность.ЛяМинор.get(6), delay, 120);
        звучать(Тональность.ЛяМинор.get(7), delay, 120);
        звучать(Тональность.ЛяМинор.get(8), delay, 120);
    }

    private static void звучать(int нота, int длительность, int сила) throws InterruptedException {
        synthChannel.noteOn(нота, сила);
        Thread.sleep(длительность);
        synthChannel.noteOff(нота);
        Thread.sleep(длительность);
    }
}
