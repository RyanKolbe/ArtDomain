package com.ryankolbe.service;

import com.ryankolbe.domain.ArtStock;

import java.util.List;

public interface ArtStockService extends IService<ArtStock, String> {
    List<ArtStock> getAll();
}