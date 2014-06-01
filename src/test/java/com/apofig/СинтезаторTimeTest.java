package com.apofig;

import com.apofig.parser.Parser;
import com.apofig.октавы.ПерваяОктава;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.sound.midi.MidiChannel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static com.apofig.октавы.ВтораяОктава.*;
import static com.apofig.октавы.ПерваяОктава.*;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * User: sanja
 * Date: 17.07.13
 * Time: 0:01
 */
public class СинтезаторTimeTest {

    private MidiChannel midi;
    private Синтезатор синтезатор;
    private List<String> timeLine = new LinkedList<String>();
    private long start = 0;

    @Before
    public void setup() {
        RealMidiChannelFactory factory = mock(RealMidiChannelFactory.class);
        midi = mock(MidiChannel.class);
        when(factory.get()).thenReturn(midi);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                if (start == 0) {
                    start = now();
                }

                int noteNumber = (Integer)invocationOnMock.getArguments()[0];
                int velocity = (Integer)invocationOnMock.getArguments()[1];

                timeLine.add("[" + (double)(now() - start)/Синтезатор.LENGTH + "]" + "+" + noteNumber + "(" + velocity + ")");
                return null;
            }
        }).when(midi).noteOn(anyInt(), anyInt());

        синтезатор = new Синтезатор(factory);
    }

    private long now() {
        return Calendar.getInstance().getTimeInMillis();
    }

    @Test
    public void should() {
//        синтезатор.звучать(Parser.parse("H5  ║+       :+       ║\n"));
//
//        assertEquals("[[0.0]+71(100), [0.063]+71(0), [0.502]+71(100), [0.5645]+71(0), [1.0035]+0(0)]", timeLine.toString());
//        timeLine.clear();

//        синтезатор.звучать(Parser.parse("H5  ║+     :+     ║\n"));
//
//        assertEquals("[[0.0]+71(100), [0.063]+71(0), [0.502]+71(100), [0.5645]+71(0), [1.0035]+0(0)]", timeLine.toString());
    }
}
