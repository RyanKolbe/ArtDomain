package com.ryankolbe.factory;

import com.ryankolbe.model.Calendar;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class CalendarFactoryTest {
    private LocalDate localDate;
    private LocalTime localTime;
    private Year year;

    @Test
    public void createCalendar() {
        localDate = LocalDate.parse("2018-12-10");
        localTime = LocalTime.parse("10:00:00");
        year = Year.parse("2018");
        Calendar calendar = CalendarFactory.createCalendar(localDate, localTime, year);
        Assert.assertEquals(Year.parse("2018"), calendar.getYear());
    }
}