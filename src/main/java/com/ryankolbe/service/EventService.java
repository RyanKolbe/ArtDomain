package com.ryankolbe.service;

import com.ryankolbe.domain.Event;

import java.util.List;

public interface EventService extends IService<Event, String> {
    List<Event> getAll();
}