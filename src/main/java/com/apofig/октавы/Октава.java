package com.apofig.октавы;

import com.apofig.Нота;
import com.apofig.Тональность;

import java.util.LinkedList;
import java.util.List;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 22:54
 */
public class Октава {

    private Нота до;
    private Октава следующая;
    private Октава предыдущая;

    public void init(Октава предыдущая, Октава следующая, int номерОктавы) {
        this.следующая = следующая;
        this.предыдущая = предыдущая;
        до = new Нота(номерОктавы*12);
    }

    public Нота get(String нота) {
        boolean диез = нота.contains("is");
        boolean бемоль = нота.contains("es") || нота.equals("As") ||  нота.equals("Es");
        switch (нота.charAt(0)) {
            case 'C':
                if (бемоль) throw new IllegalArgumentException("У 'С' нет бемоля");
                return get(1, диез, бемоль);
            case 'D':
                return get(2, диез, бемоль);
            case 'E':
                if (диез) throw new IllegalArgumentException("У 'Е' нет диеза");
                return get(3, диез, бемоль);
            case 'F':
                if (бемоль) throw new IllegalArgumentException("У 'F' нет бемоля");
                return get(4, диез, бемоль);
            case 'G':
                return get(5, диез, бемоль);
            case 'A':
                return get(6, диез, бемоль);
            case 'H':
                if (бемоль) throw new IllegalArgumentException("У 'Н' бемоль обозначатеся как 'B'");
                if (диез) throw new IllegalArgumentException("У 'Н' нет диеза");
                return get(7, диез, бемоль);
            case 'B':
                if (бемоль) throw new IllegalArgumentException("У 'B' это и есть бемоль для 'H'");
                if (диез) throw new IllegalArgumentException("У 'B' нет диеза");
                return get(6, true, бемоль);
            default:
                throw new IllegalArgumentException("Нет такой ноты");
        }
    }

    public Нота get(int номерНоты, boolean диез, boolean бемоль) {
        if (диез) {
            if (номерНоты == 3 || номерНоты == 7) {
                throw new IllegalArgumentException("У 'E', 'Н'/'B' нет диезов");
            }
            return нота(номерНоты).наПолтонаВыше();
        } else if (бемоль) {
            if (номерНоты == 1 || номерНоты == 4 || номерНоты == 4) {
                throw new IllegalArgumentException("У 'C', 'F', 'H', 'B' нет бемолей");
            }
            return нота(номерНоты).наПолтонаНиже();
        } else {
            return нота(номерНоты);
        }
    }

    private Нота нота(int номерНоты) {
        return Тональность.Мажор.get(до, номерНоты);
    }

    public Нота get(int номерНоты) {
        return get(номерНоты, false, false);
    }

    public Октава следующая() {
        return следующая;
    }

    public Октава предыдущая() {
        return предыдущая;
    }
}
