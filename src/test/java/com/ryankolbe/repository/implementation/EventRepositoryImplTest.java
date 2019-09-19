/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Event;
import com.ryankolbe.factory.EventFactory;
import com.ryankolbe.repository.EventRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EventRepositoryImplTest {
    private static EventRepository eventRepository = EventRepositoryImpl.getEventRepository();
    private static Event event;
    private static Set<Event> events = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        event = EventFactory.createEvent("0001", "Oil Lit Sky", LocalDate.parse("2018-12-31"),
                LocalTime.parse("10:00:00"));
        events.add(eventRepository.create(event));

    }

    @Test
    public void getEventRepository() {
        Assert.assertNotNull(eventRepository);
    }

    @Test
    public void create() {
        Event createEvent = EventFactory.createEvent("0002", "Carved In Stone",
                LocalDate.parse("2018-12-31"), LocalTime.parse("11:30:00"));
        events.add(eventRepository.create(createEvent));
        Assert.assertEquals(createEvent, eventRepository.read(createEvent.getEventId()));
    }

    @Test
    public void read() {
        Event readEvent = eventRepository.read(event.getEventId());
        Assert.assertEquals(readEvent, eventRepository.read(readEvent.getEventId()));
    }

    @Test
    public void update() {
        String newEventName = "Stuck On Display";
        Event updateEvent = new Event.Builder().copy(event).eventName(newEventName).build();
        events.add(eventRepository.update(updateEvent));
        Assert.assertEquals(updateEvent, eventRepository.read(updateEvent.getEventId()));
    }

    @Test
    public void delete() {
        Event deleteEvent = EventFactory.createEvent("0012", "Strokes Of Wonder",
                LocalDate.parse("2018-12-31"), LocalTime.parse("11:30:00"));
        events.add(eventRepository.create(deleteEvent));
        events.remove(deleteEvent);
        eventRepository.delete(deleteEvent.getEventId());
        Assert.assertEquals(events.size(), eventRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Event> eventSet = eventRepository.getAll();
        Assert.assertEquals(eventSet, eventRepository.getAll());
    }
}*/
