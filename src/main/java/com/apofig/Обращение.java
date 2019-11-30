package com.apofig;

import java.util.LinkedList;
import java.util.List;

public class Обращение {

    // TODO а что если уже есть такая нота в аккорде, надо брать следующий по спсику и обращать
    public static List<Нота> вверх(List<Нота> ноты) {
        return new LinkedList<Нота>(){{
            addAll(ноты.subList(1, ноты.size()));
            add(ноты.get(0).выше(Интервал.ЧистаяОктава));
        }};
    }

    // TODO а что если уже есть такая нота в аккорде, надо брать следующий по спсику и обращать
    public static List<Нота> вниз(List<Нота> ноты) {
        return new LinkedList<Нота>(){{
            add(ноты.get(ноты.size() - 1).ниже(Интервал.ЧистаяОктава));
            addAll(ноты.subList(0, ноты.size() - 1));
        }};
    }
}
