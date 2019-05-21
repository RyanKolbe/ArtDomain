package com.ryankolbe.service;

import com.ryankolbe.domain.ArtStock;

import java.util.Set;

public interface ArtStockService extends IService<ArtStock, String> {
    Set<ArtStock> getAll();
}