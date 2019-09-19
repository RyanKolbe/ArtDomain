package com.ryankolbe.service;

import com.ryankolbe.domain.Asset;

import java.util.List;

public interface AssetService extends IService<Asset, String> {
    List<Asset> getAll();
}