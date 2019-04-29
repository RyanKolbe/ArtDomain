package com.ryankolbe.factory;

import com.ryankolbe.model.Calendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class CalendarFactory {

    public static Calendar createCalendar(LocalDate date, LocalTime time, Year year) {
        return new Calendar.Builder()
                .date(date)
                .time(time)
                .year(year)
                .build();
    }
}