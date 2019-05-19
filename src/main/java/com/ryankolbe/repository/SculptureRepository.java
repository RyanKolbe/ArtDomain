package com.ryankolbe.repository;

import com.ryankolbe.domain.Sculpture;

import java.util.Set;

public interface SculptureRepository extends IRepository<Sculpture, String> {
    Set<Sculpture> getAll();
}