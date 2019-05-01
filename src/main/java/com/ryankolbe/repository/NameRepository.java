package com.ryankolbe.repository;

import com.ryankolbe.model.Name;

import java.util.Set;

public interface NameRepository extends IRepository<Name, String> {
    Set<Name> getAll();
}