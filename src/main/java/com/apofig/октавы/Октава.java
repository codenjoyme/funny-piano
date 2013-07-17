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
public abstract class Октава {

    private Нота до;
    private Октава следующая;
    private Октава предыдущая;

    public void init(Октава предыдущая, Октава следующая, int номерОктавы) {
        this.следующая = следующая;
        this.предыдущая = предыдущая;
        до = new Нота(номерОктавы*12);
    }

    public abstract Нота база();

    public Нота get(String нота) {
        boolean диез = нота.length() > 1;
        switch (нота.charAt(0)) {
            case 'C':
                return get(1, диез);
            case 'D':
                return get(2, диез);
            case 'E':
                if (диез) throw new IllegalArgumentException("У 'Е' нет диеза");
                return get(3, диез);
            case 'F':
                return get(4, диез);
            case 'G':
                return get(5, диез);
            case 'A':
                return get(6, диез);
            case 'H':
                if (диез) throw new IllegalArgumentException("У 'Н' нет диеза");
                return get(7, диез);
            case 'B':
                if (диез) throw new IllegalArgumentException("У 'B' нет диеза");
                return get(6, true);
            default:
                throw new IllegalArgumentException("Нет такой ноты");
        }
    }

    public Нота get(int номерНоты, boolean диез) {
        if (диез) {
            if (номерНоты == 3 || номерНоты == 7) {
                throw new IllegalArgumentException("У 'E', 'Н'/'B' нет диезов");
            }
            return Тональность.Мажор.get(до.наПолтонаНиже(), номерНоты + 1);
        } else {
            return Тональность.Мажор.get(до, номерНоты);
        }
    }

    public Нота get(int номерНоты) {
        return get(номерНоты, false);
    }

    public Октава следующая() {
        return следующая;
    }

    public Октава предыдущая() {
        return предыдущая;
    }
}
