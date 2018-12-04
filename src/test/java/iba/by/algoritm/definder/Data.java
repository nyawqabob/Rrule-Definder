package iba.by.algoritm.definder;

import iba.by.algoritm.entity.Event;
import iba.by.algoritm.entity.RruleFreqType;
import iba.by.algoritm.entity.UnparsedEvent;
import iba.by.algoritm.parser.EventParser;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static final Long INTERVAL_FOR_FIRST_DATES = 2L;
    public static final int AMOUNT_OF_DATES_TO_EXDATE_FOR_FIRST_DATES = 1;
    public static final RruleFreqType FREQ_FOR_FIRST_DATES = RruleFreqType.WEEKLY;

    public static final Long INTERVAL_FOR_SECOND_DATES = 2L;
    public static final int AMOUNT_OF_DATES_TO_EXDATE_FOR_SECOND_DATES = 2;
    public static final RruleFreqType FREQ_FOR_FSECOND_DATES = RruleFreqType.DAILY;

    public static final Long INTERVAL_FOR_THIRD_DATES = 3L;
    public static final int AMOUNT_OF_DATES_TO_EXDATE_FOR_THIRD_DATES = 7;
    public static final RruleFreqType FREQ_FOR_THIRD_DATES = RruleFreqType.HOURLY;

    public static final Long INTERVAL_FOR_FOURTH_DATES = 25L;
    public static final int AMOUNT_OF_DATES_TO_EXDATE_FOR_FOURTH_DATES = 1;
    public static final RruleFreqType FREQ_FOR_FOURTH_DATES = RruleFreqType.MINUTELY;

    public static final Long INTERVAL_FOR_FIFTH_DATES = 1L;
    public static final int AMOUNT_OF_DATES_TO_EXDATE_FOR_FIFTH_DATES = 167;
    public static final RruleFreqType FREQ_FOR_FIFTH_DATES = RruleFreqType.HOURLY;

    public static List<Event> getFirstEvents() {
        List<UnparsedEvent> unparsedEvents = new ArrayList<>();
        unparsedEvents.add(new UnparsedEvent("12/19/2018 11:30:00", "12/19/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("11/21/2018 11:30:00", "11/21/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("01/2/2019 11:30:00", "01/2/2019 12:30:00"));
        return EventParser.unparsedToParsed(unparsedEvents);
    }

    public static List<Event> getSecondEvents() {
        List<UnparsedEvent> unparsedEvents = new ArrayList<>();
        unparsedEvents.add(new UnparsedEvent("12/01/2018 11:30:00", "12/01/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("12/03/2018 11:30:00", "12/03/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("12/07/2018 11:30:00", "12/07/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("12/11/2018 11:30:00", "12/11/2018 12:30:00"));
        return EventParser.unparsedToParsed(unparsedEvents);
    }

    public static List<Event> getThirdEvents() {
        List<UnparsedEvent> unparsedEvents = new ArrayList<>();
        unparsedEvents.add(new UnparsedEvent("11/21/2018 06:00:00", "11/21/2018 06:30:00"));
        unparsedEvents.add(new UnparsedEvent("11/21/2018 12:00:00", "11/21/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("11/22/2018 00:00:00", "11/22/2018 00:30:00"));
        unparsedEvents.add(new UnparsedEvent("11/22/2018 12:00:00", "11/22/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("11/22/2018 15:00:00", "11/22/2018 15:30:00"));
        return EventParser.unparsedToParsed(unparsedEvents);
    }
    public static List<Event> getFourthEvents() {
        List<UnparsedEvent> unparsedEvents = new ArrayList<>();
        unparsedEvents.add(new UnparsedEvent("11/21/2018 11:00:00", "11/21/2018 11:10:00"));
        unparsedEvents.add(new UnparsedEvent("11/21/2018 11:50:00", "11/21/2018 12:00:00"));
        unparsedEvents.add(new UnparsedEvent("11/21/2018 12:15:00", "11/21/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("11/21/2018 12:40:00", "11/21/2018 12:50:00"));
        return EventParser.unparsedToParsed(unparsedEvents);
    }
    public static List<Event> getFifthEvents() {
        List<UnparsedEvent> unparsedEvents = new ArrayList<>();
        unparsedEvents.add(new UnparsedEvent("11/21/2018 11:00:00", "11/21/2018 12:00:00"));
        unparsedEvents.add(new UnparsedEvent("11/28/2018 11:00:00", "11/28/2018 12:00:00"));
        unparsedEvents.add(new UnparsedEvent("11/28/2018 12:00:00", "11/28/2018 12:30:00"));
        unparsedEvents.add(new UnparsedEvent("11/28/2018 13:00:00", "11/28/2018 13:50:00"));
        return EventParser.unparsedToParsed(unparsedEvents);
    }

}

