package com.ryankolbe.repository;

import com.ryankolbe.model.Dimension;

import java.util.Set;

public interface DimensionRepository extends IRepository<Dimension, String> {
    Set<Dimension> getAll();
}
