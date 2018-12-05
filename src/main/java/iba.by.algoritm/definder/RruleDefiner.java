package iba.by.algoritm.definder;

import iba.by.algoritm.entity.Event;
import iba.by.algoritm.entity.Rrule;
import iba.by.algoritm.wrappers.FrequenceWrapper;

import java.util.*;

public class RruleDefiner {

    public Rrule defineRrule(List<Event> events) {
        FrequenceIntervalDefiner frequenceIntervalDefiner = new FrequenceIntervalDefiner();
        Event lastEvent = events.get(events.size() - 1);
        Event firstEvent = events.get(0);
        Date startDateOfFirstEvent = firstEvent.getDateStart();
        Date startDateOfLastEvent = lastEvent.getDateEnd();
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDateOfFirstEvent);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(startDateOfLastEvent);
        List<Date> startDatesOfEvents = new LinkedList();
        events.forEach(x -> startDatesOfEvents.add(x.getDateStart()));
        FrequenceWrapper frequenceWrapper = frequenceIntervalDefiner.defineFreqAndInterval(startDatesOfEvents);
        Rrule rrule = new Rrule();
        if (frequenceWrapper.getMinimumIntervalOfFreq() == -1) {
            rrule.setInterval(1L);
        } else {
            rrule.setInterval(frequenceWrapper.getMinimumIntervalOfFreq());
        }
        rrule.setRruleFreqType(frequenceWrapper.getRruleFreqType());
        while (startCalendar.before(endCalendar)) {
            Date result = startCalendar.getTime();
            if (!((LinkedList<Date>) startDatesOfEvents).getFirst().equals(result)) {
                rrule.getExDates().add(result);
            } else {
                ((LinkedList<Date>) startDatesOfEvents).removeFirst();
            }
            startCalendar.add(rrule.getRruleFreqType().getFrequence(), rrule.getInterval().intValue());
        }
        return rrule;
    }
}
