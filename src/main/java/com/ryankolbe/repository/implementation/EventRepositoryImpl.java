package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Event;
import com.ryankolbe.repository.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("EventRepository")
public class EventRepositoryImpl implements EventRepository {
    private static EventRepositoryImpl eventRepository = null;
    private Set<Event> events;


    private EventRepositoryImpl() {
        this.events = new HashSet<>();
    }

    public static EventRepositoryImpl getEventRepository() {
        if (eventRepository == null) eventRepository = new EventRepositoryImpl();
        return eventRepository;
    }

    @Override
    public Event create(Event event) {
        this.events.add(event);
        return event;
    }

    @Override
    public Event read(String eventId) {
        return search(eventId);
    }

    @Override
    public Event update(Event event) {
        Event eventTemp = search(event.getEventId());
        if (eventTemp != null) {
            return create(new Event.Builder()
                    .copy(eventTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String eventId) {
        Event eventDelete = search(eventId);
        if (eventDelete != null) this.events.remove(eventDelete);
    }

    private Event search(final String eventId) {
        for (Event eventSearch : this.events) {
            if (eventSearch.getEventId().equals(eventId))
                return eventSearch;
        }
        return null;
    }

    @Override
    public Set<Event> getAll() {
        return this.events;
    }
}