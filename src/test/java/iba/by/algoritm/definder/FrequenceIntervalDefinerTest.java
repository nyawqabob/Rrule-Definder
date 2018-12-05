package iba.by.algoritm.definder;

import iba.by.algoritm.entity.Rrule;
import iba.by.algoritm.handler.EventSorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrequenceIntervalDefinerTest {

    private RruleDefiner rruleDefiner = new RruleDefiner();
    private EventSorter eventSorter;


    @Before
    public void setUp() {
        eventSorter = new EventSorter();
    }

    @Test
    public void shouldReturnFreqWeeklyAndIntervalTwo() {
        //given
        Data.getFirstEvents().forEach(x -> eventSorter.addEvent(x));
        eventSorter.sortEvents();
        //when
        Rrule rrule = rruleDefiner.defineRrule(eventSorter.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_FIRST_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_FIRST_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_FIRST_DATES);
    }

    @Test
    public void shouldReturnFreqDailyAndIntervalTwo() {
        //given
        Data.getSecondEvents().forEach(x -> eventSorter.addEvent(x));
        eventSorter.sortEvents();
        //when
        Rrule rrule = rruleDefiner.defineRrule(eventSorter.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_SECOND_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_FSECOND_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_SECOND_DATES);
    }

    @Test
    public void shouldReturnFreqHourlyAndIntervalThree() {
        //given
        Data.getThirdEvents().forEach(x -> eventSorter.addEvent(x));
        eventSorter.sortEvents();
        //when
        Rrule rrule = rruleDefiner.defineRrule(eventSorter.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_THIRD_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_THIRD_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_THIRD_DATES);
    }

    @Test
    public void shouldReturnFreqMinutelyAndIntervalTwentyFive() {
        //given
        Data.getFourthEvents().forEach(x -> eventSorter.addEvent(x));
        eventSorter.sortEvents();
        //when
        Rrule rrule = rruleDefiner.defineRrule(eventSorter.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_FOURTH_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_FOURTH_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_FOURTH_DATES);
    }

    @Test
    public void shouldReturnFreqHourlyAndInterval() {
        //given
        Data.getFifthEvents().forEach(x -> eventSorter.addEvent(x));
        eventSorter.sortEvents();
        //when
        Rrule rrule = rruleDefiner.defineRrule(eventSorter.getEvents());
        //then
        Assert.assertEquals(rrule.getInterval(), Data.INTERVAL_FOR_FIFTH_DATES);
        Assert.assertEquals(rrule.getRruleFreqType(), Data.FREQ_FOR_FIFTH_DATES);
        Assert.assertEquals(rrule.getExDates().size(), Data.AMOUNT_OF_DATES_TO_EXDATE_FOR_FIFTH_DATES);
    }

}