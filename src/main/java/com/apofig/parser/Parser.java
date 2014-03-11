package com.apofig.parser;

import com.apofig.Действие;
import com.apofig.Нота;
import com.apofig.Шаблон;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by Sanja on 11.03.14.
 */
public class Parser {

    public static Шаблон parse(String source) {
        List<String> lines = new LinkedList<String>();
        for (String string : source.split("\n")) {
            lines.add(string);
        }

        Set<Нота> noteSet = new TreeSet<Нота>();
        for (String line : lines) {
            int index = line.indexOf(' ');
            int index2 = line.indexOf('║');
            index = Math.min(index, index2);
            String stringNote = line.substring(0, index);
            Нота note = Нота.parse(stringNote);
            noteSet.add(note);
        }

        String[] temp = lines.get(0).split("║");
        int countTact = temp.length - 1;
        String oneTact = temp[1];
        oneTact = oneTact.replaceAll(":", "");
        int ticksPerTact = oneTact.length();
        double tick = 1.0 / ticksPerTact;

        Map<Нота, String> allNoteTacts = new TreeMap<Нота, String>();
        for (String line : lines) {
            int beginIndex = line.indexOf("║");
            String tacts = line.substring(beginIndex).replaceAll("[:║]", "");
            String trim = StringUtils.trim(line.substring(0, beginIndex));
            Нота note = Нота.parse(trim);
            allNoteTacts.put(note, tacts);
        }

        Map<Double, List<Действие>> map = new TreeMap<Double, List<Действие>>();

        for (Map.Entry<Нота, String> entry : allNoteTacts.entrySet()) {
            Нота note = entry.getKey();
            String ticks = entry.getValue();

            double time = 0.0;
            for (int index = 0; index < ticks.length(); index++) {
                if (!map.containsKey(time)) {
                    map.put(time, new LinkedList<Действие>());
                }

                if (ticks.charAt(index) != '-') {
                    if (ticks.charAt(index) == '+') {
                        map.get(time).add(new Действие(note, 100));
                    } else if (ticks.charAt(index) == ' ') {
                        if (index > 0 && ticks.charAt(index - 1) != ' ') {
                            map.get(time).add(new Действие(note, 0));
                        }
                    }
                }

                time += tick;
            }
            { // TODO как бы все ноты отпускаем в конце для того чтобы паузу выдержать, что не ок
                if (!map.containsKey(time)) {
                    map.put(time, new LinkedList<Действие>());
                }
                map.get(time).add(new Действие(note, 0));
            }
        }

        return new Шаблон(map);
    }
}
