package com.ryankolbe.repository;

import com.ryankolbe.domain.Asset;

import java.util.Set;

public interface AssetRepository extends IRepository<Asset, String> {
    Set<Asset> getAll();
}
