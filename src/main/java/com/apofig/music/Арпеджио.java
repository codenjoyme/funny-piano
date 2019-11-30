package com.apofig.music;

import com.apofig.*;
import com.apofig.parser.Printer;

import static com.apofig.октавы.ВтораяОктава.C5;

public class Арпеджио {

    public static void main(String[] args) {
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        Шаблон result = Арпеджиатор.Базовая.вверхВнизДвеРуки(Трезвучие.Минорное, C5, 1, 2);

        System.out.println(Printer.toString(result));
        синтезатор.звучать(result);

    }


}
