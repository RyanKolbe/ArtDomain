package com.ryankolbe.service;

import com.ryankolbe.domain.Asset;

import java.util.Set;

public interface AssetService extends IService<Asset, String> {
    Set<Asset> getAll();
}