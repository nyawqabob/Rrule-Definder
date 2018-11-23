package iba.by.algoritm.definder;

import iba.by.algoritm.constants.DateConstants;
import iba.by.algoritm.entity.Event;
import iba.by.algoritm.entity.Rrule;
import iba.by.algoritm.entity.RruleFreqType;

import java.util.*;

public class RruleDefinder {

    private Rrule rrule;

    public RruleDefinder(Rrule rrule) {
        this.rrule = rrule;
    }

    public void defineRruleExDates(List<Event> events) {
        Event lastEvent = events.get(events.size() - 1);
        Event firstEvent = events.get(0);
        Date startDateOfFirstEvent = firstEvent.getDateStart();
        Date startDateOfLastEvent = lastEvent.getDateEnd();
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDateOfFirstEvent);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(startDateOfLastEvent);
        List<Date> startDatesOfEvents = new ArrayList<>();
        events.forEach(x -> startDatesOfEvents.add(x.getDateStart()));
        defineRruleFreqAndInterval(startDatesOfEvents);
        while (startCalendar.before(endCalendar)) {
            Date result = startCalendar.getTime();
            if (!startDatesOfEvents.stream().anyMatch(result::equals)) {
                rrule.getExDates().add(result);
            }
            startCalendar.add(rrule.getRruleFreqType().getFrequence(), Integer.parseInt(rrule.getInterval().toString()));
        }
    }

    public void defineRruleFreqAndInterval(List<Date> startDatesOfEvents) {
        final int amountOfIntervalsBetweenDates = startDatesOfEvents.size() - 1;
        int amountOfIntervalsWhichMultipleToHour = 0;
        int amountOfIntervalsWhichMultipleToDay = 0;
        int amountOfIntervalsWhichMultipleToWeek = 0;
        long minimumIntervalIfHour = DateConstants.HOURS_IN_ONE_HUNDRED_YEARS;
        long minimumIntervalIfDay = DateConstants.DAYS_IN_ONE_HUNDRED_YEARS;
        long minimumIntervalIfWeek = DateConstants.WEEKS_IN_ONE_HUNDRED_YEARS;
        long minimumIntervalIfMinute = 0;
        for (int numberOfDates = 0; numberOfDates < amountOfIntervalsBetweenDates; numberOfDates++) {
            long timeBetweenEvents = startDatesOfEvents.get(numberOfDates + 1).getTime() - startDatesOfEvents.get(numberOfDates).getTime();
            if (timeBetweenEvents % DateConstants.MILLISECONDS_IN_WEEK == 0) {
                if (timeBetweenEvents / DateConstants.MILLISECONDS_IN_WEEK < minimumIntervalIfWeek) {
                    minimumIntervalIfWeek = timeBetweenEvents / DateConstants.MILLISECONDS_IN_WEEK;
                } else if (!((timeBetweenEvents / DateConstants.MILLISECONDS_IN_WEEK) % minimumIntervalIfWeek == 0)) {
                    minimumIntervalIfWeek = -1;
                }
                amountOfIntervalsWhichMultipleToWeek++;
                continue;
            }
            if (timeBetweenEvents % DateConstants.MILLISECONDS_IN_DAY == 0) {
                if (timeBetweenEvents / DateConstants.MILLISECONDS_IN_DAY < minimumIntervalIfDay) {
                    minimumIntervalIfDay = timeBetweenEvents / DateConstants.MILLISECONDS_IN_DAY;
                } else if (!((timeBetweenEvents / DateConstants.MILLISECONDS_IN_DAY) % minimumIntervalIfDay == 0)) {
                    minimumIntervalIfDay = -1;
                }
                amountOfIntervalsWhichMultipleToDay++;
                continue;
            }
            if (timeBetweenEvents % DateConstants.MILLISECONDS_IN_HOUR == 0) {
                if (timeBetweenEvents / DateConstants.MILLISECONDS_IN_HOUR < minimumIntervalIfHour) {
                    minimumIntervalIfHour = timeBetweenEvents / DateConstants.MILLISECONDS_IN_HOUR;
                } else if (!((timeBetweenEvents / DateConstants.MILLISECONDS_IN_HOUR) % minimumIntervalIfHour == 0)) {
                    minimumIntervalIfHour = -1;
                }
                amountOfIntervalsWhichMultipleToHour++;
                continue;
            }
            minimumIntervalIfMinute = handleMinutelyFreq(startDatesOfEvents);
            break;
        }
        if (amountOfIntervalsWhichMultipleToHour == amountOfIntervalsBetweenDates) {
            rrule.setRruleFreqType(RruleFreqType.HOURLY);
            if (minimumIntervalIfHour != -1) {
                rrule.setInterval(minimumIntervalIfHour);
            }
            return;
        }
        if (amountOfIntervalsWhichMultipleToDay == amountOfIntervalsBetweenDates) {
            rrule.setRruleFreqType(RruleFreqType.DAILY);
            if (minimumIntervalIfDay != -1) {
                rrule.setInterval(minimumIntervalIfDay);
            }
            return;
        }
        if (amountOfIntervalsWhichMultipleToWeek == amountOfIntervalsBetweenDates) {
            rrule.setRruleFreqType(RruleFreqType.WEEKLY);
            if (minimumIntervalIfWeek != -1) {
                rrule.setInterval(minimumIntervalIfWeek);
            }
            return;
        }
        if (minimumIntervalIfMinute!=-1){
            rrule.setInterval(minimumIntervalIfMinute);
        }

    }

    private long handleMinutelyFreq(List<Date> startDatesOfEvents) {
        long minimumIntervalIfMinute = DateConstants.MINUTES_IN_ONE_HUNDRED_YEARS;
        for (int numberOfDates = 0; numberOfDates < startDatesOfEvents.size() - 1; numberOfDates++) {
            long timeBetweenEvents = startDatesOfEvents.get(numberOfDates + 1).getTime() - startDatesOfEvents.get(numberOfDates).getTime();
            if (timeBetweenEvents / DateConstants.MILLISECONDS_IN_MINUTE < minimumIntervalIfMinute) {
                minimumIntervalIfMinute = timeBetweenEvents / DateConstants.MILLISECONDS_IN_MINUTE;
            } else if (!((timeBetweenEvents / DateConstants.MILLISECONDS_IN_MINUTE) % minimumIntervalIfMinute == 0)) {
                minimumIntervalIfMinute = -1;
            }
        }
        return minimumIntervalIfMinute;


    }
}
