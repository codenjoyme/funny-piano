package com.apofig.music;

import com.apofig.*;
import com.apofig.parser.Parser;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class SuperMario {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        синтезатор.звучать(get1());
    }

    public static Шаблон get1() {
        String source =
                "H5  ║        :+       ║\n" +
                "G5  ║        :+       ║\n" +
                "E5  ║++ +  + :        ║\n" +
                "C5  ║     +  :        ║\n" +
                "G4  ║        :+       ║\n" +
                "Fis4║++ + ++ :        ║\n" +
                "G3  ║        :+       ║\n" +
                "D3  ║++ + ++ :        ║\n" +
                "G2  ║        :     +  ║\n";
        return Parser.parse(source);
    }
}
