package com.apofig.parser;

import com.apofig.Шаблон;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by indigo on 25.04.2015.
 */
public class Rotator {

    public static String rotate(String source) {
        source = source.replaceAll("[=]", "║").replaceAll("[|]", "-");

        List<String> lines = new LinkedList<String>();
        int length = 0;
        for (String string : source.split("\n")) {
            if (length == 0) {
                length = string.length();
            } else {
                if (length != string.length()) {
                    throw new IllegalArgumentException("Line length is not equal to: " + length + " for string: " + string);
                }
            }
            lines.add(string);
        }

        StringBuffer result = new StringBuffer();
        for (int index = 0; index < length; index++) {
            for (String line : lines) {
                result.append(line.charAt(index));
            }
            result.append("\n");
        }
        return result.toString();
    }
}
