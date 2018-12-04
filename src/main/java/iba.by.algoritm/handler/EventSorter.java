package iba.by.algoritm.handler;

import iba.by.algoritm.entity.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventSorter {

    private List<Event> events;
    private boolean isSorted;

    public EventSorter() {
        events = new ArrayList<>();
        isSorted = false;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }

    public void sortEvents() {
        if (events.isEmpty()) {
            throw new RuntimeException("There are no any events");
        }
        Collections.sort(events);
        isSorted=true;

    }
}
