package com.apofig;

import javax.sound.midi.MidiChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:20
 */
public class Синтезатор {

    public static final int LENGTH = 1800;
    private MidiChannel midi;

    public Синтезатор(MidiChannelFactory midiFactory) {
        this.midi = midiFactory.get();
    }

    public void звучать(Нота нота, int длительность, int сила) {
        midi.noteOn(нота.частота(), сила);
        пауза(длительность);
        midi.noteOff(нота.частота());
    }

    public void звучать(List<Нота> ноты, int длительность, int сила) {
        System.out.print(ноты + "\n");
        for (Нота нота : ноты) {
            midi.noteOn(нота.частота(), сила);
        }
        пауза(длительность);
        for (Нота нота : ноты) {
            midi.noteOff(нота.частота());
        }
    }

    public void звучать(Нота нота, int сила) {
        midi.noteOn(нота.частота(), сила);
    }

    public void звучать(List<Нота> аккорд, int сила) {
        for (Нота нота : аккорд) {
            звучать(нота, сила);
        }
    }

    public void звучать(Нота отНоты, Тональность тональность, int длительность, int сила) {
        for (int index = 1; index <= 8; index++) {
            звучать(тональность.get(отНоты, index), длительность, сила);
        }
    }

    public void звучать(Нота отНоты, Трезвучие трезвучие, int сила) {
        звучать(трезвучие.get(отНоты), сила);
    }

    private void пауза(int длительность) {
        try {
            Thread.sleep(длительность);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void звучать(Шаблон шаблон) {
        for (int тик = 0; тик <= шаблон.тиков(); тик ++) {
            List<Действие> звуки = шаблон.get(тик);
            звучать(звуки);
            пауза((int)(шаблон.размерТика()*LENGTH));
        }
    }

    private void звучать(List<Действие> звуки) {
        for (Действие действие : звуки) {
            звучать(действие.нота(), действие.cила());
        }
    }

    private void звучать(Звук звук, int сила) {
        звучать(звук.ноты(), (int)(звук.доля()*LENGTH), сила);
    }
}
