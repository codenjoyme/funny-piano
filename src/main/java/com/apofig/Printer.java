package com.apofig;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by Sanja on 11.03.14.
 */
public class Printer {

    public static String toString(Шаблон шаблон) {

        Set<Нота> ноты = шаблон.всеНоты();
        Map<Нота, String> map = new HashMap<Нота, String>();
        for (Нота нота : ноты) {
            map.put(нота, StringUtils.rightPad(нота.toString(), 9) + "|");
        }

        for (int тик = 0; тик <= шаблон.тиков(); тик ++) {
            List<Действие> действия = шаблон.get(тик);
            рисуемЗвучащиеНотыВТике(map, действия);
            рисуемНеЗвучащиеНотыВТике(ноты, map, действия);
        }

        String result = "";
        for (Нота нота : ноты) {
            if (нота.частота() == 0) continue;
            result += map.get(нота) + "|\n";
        }
        return result;
    }

    private static void рисуемНеЗвучащиеНотыВТике(Set<Нота> ноты, Map<Нота, String> map, List<Действие> действия) {
        Set<Нота> нотыВТике = new HashSet<Нота>();
        for (Действие действие : действия) {
            нотыВТике.add(действие.нота());
        }

        Set<Нота> остальныеНоты = new HashSet<Нота>();
        for (Нота нота : ноты) {
            if (!нотыВТике.contains(нота)) {
                остальныеНоты.add(нота);
            }
        }

        for (Нота нота : остальныеНоты) {
            String line = map.get(нота);
            line += ' ';
            map.put(нота, line);
        }
    }

    private static void рисуемЗвучащиеНотыВТике(Map<Нота, String> map, List<Действие> действия) {
        Map<Нота, Boolean> тишина = какиеНотыТутНеЗвучат(действия);

        for (Map.Entry<Нота, Boolean> entry : тишина.entrySet()) {
            String line = map.get(entry.getKey());
            if (entry.getValue()) {
                line += ' ';
            } else {
                line += '+';
            }
            map.put(entry.getKey(), line);
        }
    }

    private static Map<Нота, Boolean> какиеНотыТутНеЗвучат(List<Действие> действия) {
        Map<Нота, Boolean> тишина = new HashMap<Нота, Boolean>();
        for (Действие действие : действия) {
            Нота нота = действие.нота();
            if (действие.cила() == 0) {
                if (!тишина.containsKey(нота)) {
                    тишина.put(нота, true);
                }
            } else {
                тишина.put(нота, false);
            }
        }
        return тишина;
    }
}
