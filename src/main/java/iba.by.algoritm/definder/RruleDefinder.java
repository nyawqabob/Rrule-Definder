package iba.by.algoritm.definder;

import iba.by.algoritm.constants.DateConstants;
import iba.by.algoritm.entity.RruleFreqType;
import iba.by.algoritm.wrappers.FrequenceWrapper;
import iba.by.algoritm.wrappers.IntervalWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RruleDefinder {

    public FrequenceWrapper defineRruleFreqAndInterval(List<Date> startDatesOfEvents) {
        final int amountOfDurationsBetweenDates = startDatesOfEvents.size() - 1;
        IntervalDefiner timeHandler = new IntervalDefiner();
        int amountOfDurationsWhichMultipleToMinute = 0;
        int amountOfDurationsWhichMultipleToHour = 0;
        int amountOfDurationsWhichMultipleToDay = 0;
        int amountOfDurationsWhichMultipleToWeek = 0;
        long minimumIntervalIfMinute = DateConstants.MINUTES_IN_ONE_HUNDRED_YEARS;
        long minimumIntervalIfHour = DateConstants.HOURS_IN_ONE_HUNDRED_YEARS;
        long minimumIntervalIfDay = DateConstants.DAYS_IN_ONE_HUNDRED_YEARS;
        long minimumIntervalIfWeek = DateConstants.WEEKS_IN_ONE_HUNDRED_YEARS;
        for (int numberOfDates = 0; numberOfDates < amountOfDurationsBetweenDates; numberOfDates++) {
            long timeBetweenEvents = startDatesOfEvents.get(numberOfDates + 1).getTime() - startDatesOfEvents.get(numberOfDates).getTime();
            IntervalWrapper intervalWrapperForWeek = timeHandler.defineInterval(RruleFreqType.WEEKLY, timeBetweenEvents, minimumIntervalIfWeek);
            minimumIntervalIfWeek = intervalWrapperForWeek.getMinimumIntervalOfFreq();
            if (intervalWrapperForWeek.isDurationMultipleToFreq()) {
                amountOfDurationsWhichMultipleToWeek++;
            }
            IntervalWrapper intervalWrapperForDay = timeHandler.defineInterval(RruleFreqType.DAILY, timeBetweenEvents, minimumIntervalIfDay);
            minimumIntervalIfDay = intervalWrapperForDay.getMinimumIntervalOfFreq();
            if (intervalWrapperForDay.isDurationMultipleToFreq()) {
                amountOfDurationsWhichMultipleToDay++;
            }
            IntervalWrapper intervalWrapperForHour = timeHandler.defineInterval(RruleFreqType.HOURLY, timeBetweenEvents, minimumIntervalIfHour);
            minimumIntervalIfHour = intervalWrapperForHour.getMinimumIntervalOfFreq();
            if (intervalWrapperForHour.isDurationMultipleToFreq()) {
                amountOfDurationsWhichMultipleToHour++;
            }
            IntervalWrapper intervalWrapperForMinute = timeHandler.defineInterval(RruleFreqType.MINUTELY, timeBetweenEvents, minimumIntervalIfMinute);
            minimumIntervalIfMinute = intervalWrapperForMinute.getMinimumIntervalOfFreq();
            if (intervalWrapperForMinute.isDurationMultipleToFreq()) {
                amountOfDurationsWhichMultipleToMinute++;
            }
        }
        List<FrequenceWrapper> candidates = new ArrayList<>();
        candidates.add(new FrequenceWrapper(RruleFreqType.WEEKLY, amountOfDurationsWhichMultipleToWeek, minimumIntervalIfWeek));
        candidates.add(new FrequenceWrapper(RruleFreqType.DAILY, amountOfDurationsWhichMultipleToDay, minimumIntervalIfDay));
        candidates.add(new FrequenceWrapper(RruleFreqType.HOURLY, amountOfDurationsWhichMultipleToHour, minimumIntervalIfHour));
        candidates.add(new FrequenceWrapper(RruleFreqType.MINUTELY, amountOfDurationsWhichMultipleToMinute, minimumIntervalIfMinute));
        FrequenceDefinder frequenceDefinder = new FrequenceDefinder();
        return  frequenceDefinder.defineFrequence(candidates, amountOfDurationsBetweenDates);

    }

}
