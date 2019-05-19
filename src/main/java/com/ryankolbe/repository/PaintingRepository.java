package com.ryankolbe.repository;

import com.ryankolbe.domain.Painting;

import java.util.Set;

public interface PaintingRepository extends IRepository<Painting, String> {
    Set<Painting> getAll();
}