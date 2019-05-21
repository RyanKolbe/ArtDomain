package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Event;
import com.ryankolbe.repository.EventRepository;
import com.ryankolbe.repository.implementation.EventRepositoryImpl;
import com.ryankolbe.service.EventService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("EventServiceImpl")
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    private EventServiceImpl() {
        this.eventRepository = EventRepositoryImpl.getEventRepository();
    }

    @Override
    public Set<Event> getAll() {
        return this.eventRepository.getAll();
    }

    @Override
    public Event create(Event event) {
        return this.eventRepository.create(event);
    }

    @Override
    public Event read(String eventId) {
        return this.eventRepository.read(eventId);
    }

    @Override
    public Event update(Event event) {
        return this.eventRepository.update(event);
    }

    @Override
    public void delete(String eventId) {
        this.eventRepository.delete(eventId);
    }
}