package com.ryankolbe.repository;

import com.ryankolbe.domain.ArtStock;

import java.util.Set;

public interface ArtStockRepository extends IRepository<ArtStock, String> {
    Set<ArtStock> getAll();
}