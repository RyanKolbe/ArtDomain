package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Event;
import com.ryankolbe.repository.EventRepository;
import com.ryankolbe.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EventServiceImpl")
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event create(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Event read(String eventId) {
        Optional<Event> byId = this.eventRepository.findById(eventId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Event update(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public void delete(String eventId) {
        this.eventRepository.deleteById(eventId);
    }
}