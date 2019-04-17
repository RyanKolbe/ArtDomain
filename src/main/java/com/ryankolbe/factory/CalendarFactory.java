package com.ryankolbe.factory;

import com.ryankolbe.model.Calendar;

public class CalendarFactory {

    public static Calendar createCalendar(String date, String year) {
        return new Calendar.Builder()
                .date(date)
                .year(year)
                .build();
    }
}
