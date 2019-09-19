/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Asset;
import com.ryankolbe.repository.AssetRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AssetRepository")
public class AssetRepositoryImpl implements AssetRepository {
    private static AssetRepositoryImpl assetRepository = null;
    private Set<Asset> assets;


    private AssetRepositoryImpl() {
        this.assets = new HashSet<>();
    }

    public static AssetRepositoryImpl getAssetRepository() {
        if (assetRepository == null) assetRepository = new AssetRepositoryImpl();
        return assetRepository;
    }

    @Override
    public Asset create(Asset asset) {
        this.assets.add(asset);
        return asset;
    }

    @Override
    public Asset read(String assetId) {
        return search(assetId);
    }

    @Override
    public Asset update(Asset asset) {
        Asset assetTemp = search(asset.getAssetId());
        if (assetTemp != null) {
            assets.remove(assetTemp);
            return create(asset);
        }
        return null;
    }

    @Override
    public void delete(String assetId) {
        Asset assetDelete = search(assetId);
        if (assetDelete != null) this.assets.remove(assetDelete);
    }

    private Asset search(final String assetId) {
        for (Asset assetSearch : this.assets) {
            if (assetSearch.getAssetId().equals(assetId))
                return assetSearch;
        }
        return null;
    }

    @Override
    public Set<Asset> getAll() {
        return this.assets;
    }
}*/
