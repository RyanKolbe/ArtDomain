package com.ryankolbe.repository;

import com.ryankolbe.model.Exhibit;

import java.util.Set;

public interface ExhibitRepository extends IRepository<Exhibit, String> {
    Set<Exhibit> getAll();
}
