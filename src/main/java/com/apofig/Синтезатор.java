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

    public void звучать(final int сила, final Шаблон шаблоны) {
        final LinkedList<Boolean> закончили = new LinkedList<Boolean>();
        for (final Шаблон шаблон : шаблоны) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    закончили.add(false);
                    for (Звук звук : шаблон.звуки()) {
                        звучать(звук, сила);
                    }
                    закончили.poll();

                    Шаблон следующий = шаблоны.следующий();
                    if (закончили.isEmpty() && следующий != null) {
                        звучать(сила, следующий);
                    }
                }
            }).start();
        }
    }

    private void звучать(Звук звук, int сила) {
        звучать(звук.ноты(), (int)(звук.доля()*1500), сила);
    }
}
