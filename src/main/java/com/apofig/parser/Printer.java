package com.apofig.parser;

import com.apofig.Действие;
import com.apofig.Нота;
import com.apofig.Шаблон;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by Sanja on 11.03.14.
 */
public class Printer {

    public static final char ТАКТОВАЯ_ЧЕРТА = '║';
    private static final char ПОЛУ_ТАКТОВАЯ_ЧЕРТА = ':';

    public static String toString(Шаблон шаблон) {
        Set<Нота> ноты = шаблон.всеНоты();
        Map<Нота, String> map = new HashMap<Нота, String>();
        for (Нота нота : ноты) {
            map.put(нота, StringUtils.rightPad(нота.toString(), 9) + ТАКТОВАЯ_ЧЕРТА);
        }

        Map<Нота, Состояние> состояние = new HashMap<Нота, Состояние>();
        double время = 0.0;
        for (int тик = 0; тик < шаблон.тиков(); тик ++) {
            Set<Действие> действия = шаблон.get(тик);

            for (Действие действие : действия) {
                Нота нота = действие.нота();
                if (действие.cила() == 0) {
                    состояние.put(нота, Состояние.Отжали);
                } else {
                    состояние.put(нота, Состояние.Нажали);
                }
            }

            for (Нота нота : какиеНотыНеТрогали(действия, ноты)) {
                if (состояние.get(нота) == null) {
                    состояние.put(нота, Состояние.Отжали);
                } else if (состояние.get(нота) == Состояние.Нажали) {
                    состояние.put(нота, Состояние.Держим);
                }
            }

            рисуемНотыВТике(map, состояние);

            время += шаблон.размерТика();
            if (время - Math.ceil(время) == 0) {
                рисуемТактовуюЧерту(map, ТАКТОВАЯ_ЧЕРТА);
            } else if (время/0.5 - Math.ceil(время/0.5) == 0) {
                рисуемТактовуюЧерту(map, ПОЛУ_ТАКТОВАЯ_ЧЕРТА);
            }
        }

        String result = "";
        for (Нота нота : ноты) {
            if (нота.частота() == 0) continue;
            String s = map.get(нота);
            String end = (s.charAt(s.length() - 1) != ТАКТОВАЯ_ЧЕРТА) ? "" + ТАКТОВАЯ_ЧЕРТА : "";
            result = s + end + "\n" + result;
        }
        return result;
    }

    private static void рисуемТактовуюЧерту(Map<Нота, String> map, char черта) {
        for (Нота нота : map.keySet()) {
            String line = map.get(нота);
            line += черта;
            map.put(нота, line);
        }
    }

    private static void рисуемНотыВТике(Map<Нота, String> map, Map<Нота, Состояние> действия) {
        for (Map.Entry<Нота, Состояние> entry : действия.entrySet()) {
            String line = map.get(entry.getKey());
            switch (entry.getValue()) {
                case Нажали : line += '+'; break;
                case Держим : line += '-'; break;
                case Отжали : line += ' '; break;
            }
            map.put(entry.getKey(), line);
        }
    }

    private static Set<Нота> какиеНотыНеТрогали(Set<Действие> действия, Set<Нота> всеНоты) {
        Set<Нота> дернулиНоты = new HashSet<Нота>();
        for (Действие действие : действия) {
            Нота нота = действие.нота();
            дернулиНоты.add(нота);
        }

        Set<Нота> неДергалиНоты = new HashSet<Нота>(всеНоты);
        for (Нота нота : дернулиНоты) {
            неДергалиНоты.remove(нота);
        }

        return неДергалиНоты;
    }
}

