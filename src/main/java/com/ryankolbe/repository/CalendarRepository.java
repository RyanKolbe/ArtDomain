package com.ryankolbe.repository;

import com.ryankolbe.model.Calendar;

import java.util.Set;

public interface CalendarRepository extends IRepository<Calendar, String> {
    Set<Calendar> getAll();
}