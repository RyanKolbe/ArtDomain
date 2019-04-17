package com.ryankolbe.factory;

import com.ryankolbe.model.Calendar;
import org.junit.Assert;
import org.junit.Test;

public class CalendarFactoryTest {

    @Test
    public void createCalendar() {
        Calendar calendar = CalendarFactory.createCalendar("14.07.2019", "2019");
        Assert.assertNotNull(calendar);
    }
}