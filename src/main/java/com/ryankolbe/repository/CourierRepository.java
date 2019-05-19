package com.ryankolbe.repository;

import com.ryankolbe.domain.Courier;

import java.util.Set;

public interface CourierRepository extends IRepository<Courier, String> {
    Set<Courier> getAll();
}
