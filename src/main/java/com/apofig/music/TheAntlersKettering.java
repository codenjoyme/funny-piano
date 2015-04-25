package com.apofig.music;

import com.apofig.RealMidiChannelFactory;
import com.apofig.parser.Parser;
import com.apofig.parser.Rotator;
import com.apofig.Синтезатор;
import com.apofig.Шаблон;

/**
 * User: sanja
 * Date: 16.07.13
 * Time: 21:24
 */
public class TheAntlersKettering {

    public static void main(String[] args) {
        Синтезатор.LENGTH = 3000;
        Синтезатор синтезатор = new Синтезатор(new RealMidiChannelFactory());

        синтезатор.звучать(get1());
    }

    public static Шаблон get1() {
        String source =
                "CCDDEFFGGAAHCCDDEFFGGAAHCCDDEFFGGAAHCCDDEFFGGAAH\n" +
                "3i3i33i3i3i34i4i44i4i4i45i5i55i5i5i56i6i66i6i6i6\n" +
                " s s  s s s  s s  s s s  s s  s s s  s s  s s s \n" +
                " 3 3  3 3 3  4 4  4 4 4  5 5  5 5 5  6 6  6 6 6 \n" +
                "================================================\n" +
                "                                 +  +           \n" +
                "                                 |  |           \n" +
                "                                 +  +           \n" +
                "                                 |  |           \n" +
                "                                 +  +           \n" +
                "                                 |  |           \n" +
                "                                 +  +           \n" +
                "                                 |  |           \n" +
                "                                 +  +           \n" +
                "                                 |  |           \n" +
                "                                 +  +           \n" +
                "                                 |  |           \n" +
                "                                 +  +           \n" +
                "                                 |  |           \n" +
                "                                   +  +         \n" +
                "                                   |  |         \n" +
//              "C D EF G A HC D EF G A HC D EF G A HC D EF G A H\n" +
//              "3 3 33 3 3 34 4 44 4 4 45 5 55 5 5 56 6 66 6 6 6\n" +
                "================================================\n" +
                "                        +           +   +       \n" +
                "                        |           |   |       \n" +
                "                        |           +   +       \n" +
                "                        |           |   |       \n" +
                "                        |           +   +       \n" +
                "                        |           |   |       \n" +
                "                        |           +   +       \n" +
                "                        |           |   |       \n" +
                "                                    +   +       \n" +
                "                                    |   |       \n" +
                "                                    +   +       \n" +
                "                                    |   |       \n" +
                "                                    +   +       \n" +
                "                                    |   |       \n" +
                "                                    +   +       \n" +
                "                                    |   |       \n" +
//              "C D EF G A HC D EF G A HC D EF G A HC D EF G A H\n" +
//              "3 3 33 3 3 34 4 44 4 4 45 5 55 5 5 56 6 66 6 6 6\n" +
                "================================================\n" +
                "                       +           +  +         \n" +
                "                       |           |  |         \n" +
                "                       |           +  +         \n" +
                "                       |           |  |         \n" +
                "                       |           +  +         \n" +
                "                       |           |  |         \n" +
                "                       |           +  +         \n" +
                "                       |           |  |         \n" +
                "                                   ++           \n" +
                "                                   ||           \n" +
                "                                   ++           \n" +
                "                                   ||           \n" +
                "                                   ++           \n" +
                "                                   ||           \n" +
                "                                   +            \n" +
                "                                   |            \n" +
//              "C D EF G A HC D EF G A HC D EF G A HC D EF G A H\n" +
//              "3 3 33 3 3 34 4 44 4 4 45 5 55 5 5 56 6 66 6 6 6\n" +
                "================================================\n" +
                "                     +           +  +           \n" +
                "                     |             +            \n" +
                "                     |           +              \n" +
                "                     |           |              \n" +
                "                     |           +              \n" +
                "                     |           |              \n" +
                "                     |           +              \n" +
                "                     |           |              \n" +
                "                                 +              \n" +
                "                                 |              \n" +
                "                                 +              \n" +
                "                                 |              \n" +
                "                                 +              \n" +
                "                                 |              \n" +
                "                                 +              \n" +
                "                                 |              \n" +
//              "C D EF G A HC D EF G A HC D EF G A HC D EF G A H\n" +
//              "3 3 33 3 3 34 4 44 4 4 45 5 55 5 5 56 6 66 6 6 6\n" +
                "================================================\n";
        return Parser.parse(Rotator.rotate(source));
    }
}