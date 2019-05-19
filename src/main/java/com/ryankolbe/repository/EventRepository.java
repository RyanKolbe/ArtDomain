package com.ryankolbe.repository;

import com.ryankolbe.domain.Event;

import java.util.Set;

public interface EventRepository extends IRepository<Event, String> {
    Set<Event> getAll();
}