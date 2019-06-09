package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Event;
import com.ryankolbe.factory.EventFactory;
import com.ryankolbe.service.EventService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EventServiceImplTest {
    @Autowired
    @Qualifier("EventServiceImpl")
    private EventService eventService;
    private Event event;
    private Set<Event> events = new HashSet<>();

    @Before
    public void setUp() {
        event = eventService.create(EventFactory.createEvent("0001", "Birds By Design",
                LocalDate.parse("2018-12-02"), LocalTime.parse("10:15:00")));
        events.add(event);
    }

    @Test
    public void create() {
        Event createEvent = eventService.create(EventFactory.createEvent("0023", "Woven Desires",
                LocalDate.parse("2018-12-02"), LocalTime.parse("10:45:00")));
        events.add(createEvent);
        Assert.assertEquals(createEvent, eventService.read(createEvent.getEventId()));
    }

    @Test
    public void read() {
        Event readEvent = eventService.read(event.getEventId());
        Assert.assertEquals(readEvent, eventService.read(readEvent.getEventId()));
    }

    @Test
    public void update() {
        String newEventName = "Rocking the Stones";
        Event updateEvent = eventService.update(new Event.Builder().copy(event).eventName(newEventName).build());
        events.add(updateEvent);
        Assert.assertEquals(updateEvent, eventService.read(updateEvent.getEventId()));
    }

    @Test
    public void delete() {
        events.addAll(eventService.getAll());
        Event deleteEvent = eventService.create(EventFactory.createEvent("0897", "Oil and Water",
                LocalDate.parse("2018-12-02"), LocalTime.parse("10:45:00")));
        events.add(deleteEvent);
        events.remove(deleteEvent);
        eventService.delete(deleteEvent.getEventId());
        Assert.assertEquals(events.size(), eventService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Event> eventSet = eventService.getAll();
        Assert.assertEquals(eventSet.size(), eventService.getAll().size());
    }
}