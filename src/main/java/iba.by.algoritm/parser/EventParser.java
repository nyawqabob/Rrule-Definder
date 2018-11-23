package iba.by.algoritm.parser;

import iba.by.algoritm.entity.Event;
import iba.by.algoritm.entity.UnparsedEvent;

import java.util.ArrayList;
import java.util.List;

public class EventParser {

    public static List<Event> unparsedToParsed(List<UnparsedEvent> unparsedEvents){
        List<Event> events = new ArrayList<>();
        unparsedEvents.forEach(x->events.add(new Event(DateParser.stringToDate(x.getStartDate()), DateParser.stringToDate(x.getEndDate()))));
        return events;
    }
}
