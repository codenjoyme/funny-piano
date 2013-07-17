package com.apofig;

import com.apofig.октавы.ПерваяОктава;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 1:05
 */
public class Аккорды {

    private static Map<String, List<Нота>> аккорды = new HashMap<String, List<Нота>>();

    static {
        аккорды.put("C", Трезвучие.Мажорное.get(ПерваяОктава.C4));
    }

    public static List<Нота> get(String имя) {
        return get(имя, 0);
    }

    public static List<Нота> get(String имя, int смещение) {
        List<Нота> ноты = аккорды.get(имя);
        while (смещение > 0) {
            смещение--;
            Нота нота = ноты.remove(0);
            ноты.add(2, нота.наОктавуВыше());
        }
        while (смещение < 0) {
            смещение++;
            Нота нота = ноты.remove(2);
            ноты.add(0, нота.наОктавуНиже());
        }
        return ноты;
    }
}
