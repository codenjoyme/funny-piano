package com.apofig;

import java.util.*;

/**
 * User: sanja
 * Date: 26.07.13
 * Time: 20:16
 */
public class Шаблон {

    private Map<Double, List<Действие>> map = new TreeMap<Double, List<Действие>>();

    public Шаблон(Map<Double, List<Действие>> map) {
        this.map = map;
    }

    public Шаблон(Звук звук) {
        apply(0, звук);
    }

    public Шаблон(Шаблон шаблон) {
        apply(0, шаблон);
    }

    public static Шаблон подряд(Звук... звуки) {
        Шаблон копия = null;
        for (Звук звук : звуки) {
            if (копия == null) {
                копия = подряд(звук);
            } else {
                копия = копия.потом(звук);
            }
        }
        return копия;
    }

    public static Шаблон подряд(Звук звук) {
        return new Шаблон(звук);
    }

    public Шаблон потом(Звук... звуки) {
        Шаблон копия = this;
        for (Звук звук : звуки) {
            копия = копия.потом(звук);
        }
        return копия;
    }

    public Шаблон потом(Звук звук) {
        Шаблон копия = this.копия();
        копия.apply(всего(), звук);
        return копия;
    }

    private double всего() {
        double result = 0;
        for (Map.Entry<Double, List<Действие>> entry : map.entrySet()) {
            result = Math.max(result, entry.getKey());
        }
        return result;
    }

    public Шаблон вместе(Звук... звуки) {
        Шаблон копия = this.копия();
        копия.apply(0, Шаблон.подряд(звуки));
        return копия;
    }

    public Шаблон вместе(Шаблон шаблон) {
        Шаблон копия = this.копия();
        копия.apply(0, шаблон.копия());
        return копия;
    }

    public Шаблон потом(Шаблон... шаблоны) {
        Шаблон копия = this.копия();
        for (Шаблон шаблон : шаблоны) {
            копия = копия.потом(шаблон);
        }
        return копия;
    }

    public Шаблон потом(Шаблон шаблон) {
        Шаблон копия = this.копия();
        копия.apply(всего(), шаблон.копия());
        return копия;
    }

    private Шаблон копия() {
        return new Шаблон(this);
    }

    public int тиков() {
        return (int)(всего()/размерТика());
    }

    public List<Действие> get(int тик) {
        List<Действие> list = map.get(размерТика() * тик);
        if (list == null) {
            list = new LinkedList<Действие>();
        }
        return list;
    }

    public double размерТика() {
        double result = всего();
        double last = 0;
        for (Map.Entry<Double, List<Действие>> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                continue;
            }

            result = Math.min(result, entry.getKey() - last);
            last = entry.getKey();
        }
        return result;
    }

    private void apply(double смещение, Шаблон шаблон) {
        for (Map.Entry<Double, List<Действие>> entry : шаблон.map.entrySet()) {
            get(entry.getKey() + смещение).addAll(entry.getValue());
        }
    }

    private void apply(double смещение, Звук звук) {
        List<Нота> ноты = звук.ноты();
        int сила = звук.сила();

        apply(смещение, ноты, сила);
        apply(смещение + звук.доля(), ноты, 0);
    }

    private void apply(double смещение, List<Нота> ноты, int сила) {
        for (Нота нота : ноты) {
            get(смещение).add(new Действие(нота, сила));
        }
    }

    private List<Действие> get(double смещение) {
        if (map.get(смещение) == null) {
            map.put(смещение, new LinkedList<Действие>());
        }
        return map.get(смещение);
    }

    @Override
    public String toString() {
        return map.toString().replaceAll("\\]\\], ", "]],\n").replaceAll("\\[\\], ", "[],\n");
    }

    public double длинна() {
        return тиков()*размерТика();
    }

    public Шаблон частьДо(double конец) {
        double начало = 0.0;

        List<Double> remove = new LinkedList<Double>();

        Шаблон копия = this.копия();
        for (Map.Entry<Double, List<Действие>> entry : копия.map.entrySet()) {
            if (entry.getKey() < начало*длинна() || конец*длинна() <= entry.getKey()) {
                remove.add(entry.getKey());
            }
        }

        List<Действие> граница = копия.get(конец*длинна());

        for (Double key : remove) {
            List<Действие> list = копия.get(key);
            for (Действие действие : list.toArray(new Действие[0])) {
                list.remove(действие);
                Действие стоп = new Действие(действие.нота(), 0);

                if (!граница.contains(стоп)) {
                    граница.add(стоп);
                }
            }
        }

//        for (Действие награнице : граница.toArray(new Действие[0])) {
//            boolean естьНачалоУНоты = false;
//                // TODO в test9 есть обрезание ноты D4 на границе обрезание, но она там и не звучала.
//                for (Действие действие : копия.all()) {
//                    if (действие.нота().частота() == награнице.нота().частота() && награнице.cила() == 0) {
//                        естьНачалоУНоты = true;
//                        break;
//                    }
//                }
//                if (!естьНачалоУНоты) {
//                    граница.remove(награнице);
//                }
//        }


        List<Double> remove2 = new LinkedList<Double>();
        for (Map.Entry<Double, List<Действие>> entry : копия.map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                remove2.add(entry.getKey());
            }
        }
        for (Double key : remove2) {
            копия.map.remove(key);
        }

        return копия;
    }

    public Шаблон повтор(int раз) {
        Шаблон result = this;
        for (int index = 1; index < раз; index ++) {
            result = result.потом(this);
        }
        return result;
    }

    public Set<Нота> всеНоты() {
        Set<Нота> ноты = new TreeSet<Нота>();
        for (List<Действие> действия : map.values()) {
            for (Действие действие : действия) {
                ноты.add(действие.нота());
            }
        }
        return ноты;
    }
}
