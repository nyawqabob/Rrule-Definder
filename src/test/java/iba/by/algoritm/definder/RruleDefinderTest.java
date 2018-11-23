package iba.by.algoritm.definder;

import iba.by.algoritm.entity.Rrule;
import iba.by.algoritm.handler.EventHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RruleDefinderTest {

    private RruleDefinder rruleDefinder;
    private Rrule rrule;
    private EventHandler eventHandler;


    @Before
    public void setUp() {
        eventHandler = new EventHandler();
        rrule = new Rrule();
        rruleDefinder = new RruleDefinder(rrule);
    }

    @Test
    public void shouldReturnFreqWeeklyAndIntervalTwo() {
        //given
        Data.getFirstEvents().forEach(x -> eventHandler.addEvent(x));
        eventHandler.sortEvents();
        //when
        rruleDefinder.defineRruleExDates(eventHandler.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_FIRST_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_FIRST_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_FIRST_DATES);
    }

    @Test
    public void shouldReturnFreqDailyAndIntervalTwo() {
        //given
        Data.getSecondEvents().forEach(x -> eventHandler.addEvent(x));
        eventHandler.sortEvents();
        //when
        rruleDefinder.defineRruleExDates(eventHandler.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_SECOND_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_FSECOND_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_SECOND_DATES);
    }

    @Test
    public void shouldReturnFreqHourlyAndIntervalThree() {
        //given
        Data.getThirdEvents().forEach(x -> eventHandler.addEvent(x));
        eventHandler.sortEvents();
        //when
        rruleDefinder.defineRruleExDates(eventHandler.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_THIRD_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_THIRD_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_THIRD_DATES);
    }

    @Test
    public void shouldReturnFreqMinutelyAndIntervalTwentyFive() {
        //given
        Data.getFourthEvents().forEach(x -> eventHandler.addEvent(x));
        eventHandler.sortEvents();
        //when
        rruleDefinder.defineRruleExDates(eventHandler.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_FOURTH_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_FOURTH_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_FOURTH_DATES);
    }

}