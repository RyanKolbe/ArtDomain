package com.ryankolbe.repository;

import com.ryankolbe.model.Locality;

import java.util.Set;

public interface LocalityRepository extends IRepository<Locality, String> {
    Set<Locality> getAll();
}
