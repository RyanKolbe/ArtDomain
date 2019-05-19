package com.ryankolbe.repository;

import com.ryankolbe.domain.Exhibition;

import java.util.Set;

public interface ExhibitionRepository extends IRepository<Exhibition, String> {
    Set<Exhibition> getAll();
}