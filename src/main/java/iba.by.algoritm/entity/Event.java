package iba.by.algoritm.entity;

import java.util.Date;

public class Event implements Comparable<Event> {

    private Date dateStart;
    private Date dateEnd;

    public Event(Date dateStart, Date dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public int compareTo(Event anotherEvent) {
        long thisEventDuration = this.getDateEnd().getTime() - getDateStart().getTime();
        long anotherEventDuration = anotherEvent.getDateEnd().getTime() - getDateStart().getTime();
        return thisEventDuration < anotherEventDuration ? -1 : thisEventDuration > anotherEventDuration ? 1 : 0;
    }
}
