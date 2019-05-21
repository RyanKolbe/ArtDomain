package com.ryankolbe.service;

import com.ryankolbe.domain.Event;

import java.util.Set;

public interface EventService extends IService<Event, String> {
    Set<Event> getAll();
}