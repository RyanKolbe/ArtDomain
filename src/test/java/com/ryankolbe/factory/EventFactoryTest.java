package com.ryankolbe.factory;

import com.ryankolbe.domain.Event;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventFactoryTest {

    @Test
    public void createEvent() {
        Event event = EventFactory.createEvent("0001", "Harvest Festival",
                LocalDate.parse("2018-10-01"), LocalTime.parse("10:30:00"));
        Assert.assertEquals(LocalDate.parse("2018-10-01"), event.getEventDate());
    }
}