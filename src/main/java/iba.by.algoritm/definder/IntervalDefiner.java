package iba.by.algoritm.definder;

import iba.by.algoritm.constants.DateConstants;
import iba.by.algoritm.constants.EnumConstants;
import iba.by.algoritm.entity.RruleFreqType;
import iba.by.algoritm.wrappers.IntervalWrapper;

public class IntervalDefiner {

    public IntervalWrapper defineInterval(RruleFreqType rruleFreqType, long timeBetweenEvents, long minimumInterval) {
        IntervalWrapper intervalWrapper = new IntervalWrapper(false, minimumInterval);
        long millisecondsInFreq = 0;
        long freqsInOneHundreedYears = 0;
        switch (rruleFreqType.ordinal()) {
            case EnumConstants.ORDINAL_OF_WEEKLY:
                millisecondsInFreq = DateConstants.MILLISECONDS_IN_WEEK;
                freqsInOneHundreedYears = DateConstants.WEEKS_IN_ONE_HUNDRED_YEARS;
                break;
            case EnumConstants.ORDINAL_OF_DAILY:
                millisecondsInFreq = DateConstants.MILLISECONDS_IN_DAY;
                freqsInOneHundreedYears = DateConstants.DAYS_IN_ONE_HUNDRED_YEARS;
                break;
            case EnumConstants.ORDINAL_OF_HOURLY:
                millisecondsInFreq = DateConstants.MILLISECONDS_IN_HOUR;
                freqsInOneHundreedYears = DateConstants.HOURS_IN_ONE_HUNDRED_YEARS;
                break;
            case EnumConstants.ORDINAL_OF_MINUTELY:
                millisecondsInFreq = DateConstants.MILLISECONDS_IN_MINUTE;
                freqsInOneHundreedYears = DateConstants.MINUTES_IN_ONE_HUNDRED_YEARS;
        }
        if (timeBetweenEvents % millisecondsInFreq == 0) {
            intervalWrapper.setDurationMultipleToFreq(true);
            long possibleInterval = timeBetweenEvents / millisecondsInFreq;
            if (possibleInterval < minimumInterval) {
                if (minimumInterval % possibleInterval == 0 || minimumInterval == freqsInOneHundreedYears) {
                    intervalWrapper.setMinimumIntervalOfFreq(possibleInterval);
                } else {
                    intervalWrapper.setMinimumIntervalOfFreq(-1);
                }
            } else if (!((possibleInterval) % minimumInterval == 0)) {
                intervalWrapper.setMinimumIntervalOfFreq(-1);
            }
        }
        return intervalWrapper;
    }

}
