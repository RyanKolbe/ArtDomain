package com.ryankolbe.factory;

import com.ryankolbe.domain.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventFactory {

    public static Event createEvent(String eventId, String eventName, LocalDate eventDate, LocalTime eventTime) {
        return new Event.Builder()
                .eventId(eventId)
                .eventName(eventName)
                .eventDate(eventDate)
                .eventTime(eventTime)
                .build();
    }
}