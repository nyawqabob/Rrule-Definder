package iba.by.algoritm.parser;

import iba.by.algoritm.constants.DateConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DateConstants.DATE_FORMAT);

    public static Date stringToDate(String date) {
        Date returnedDate;
        try {
            returnedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return returnedDate;
    }

}
