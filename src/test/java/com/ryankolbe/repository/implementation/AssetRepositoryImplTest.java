/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Asset;
import com.ryankolbe.factory.AssetFactory;
import com.ryankolbe.repository.AssetRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssetRepositoryImplTest {
    private static AssetRepository assetRepository = AssetRepositoryImpl.getAssetRepository();
    private static Asset asset;
    private static Set<Asset> assets = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        asset = AssetFactory.createAsset("0001", "1234", "Latitude e5550",
                10000.00);
        assets.add(assetRepository.create(asset));
    }

    @Test
    public void getAssetRepository() {
        Assert.assertNotNull(assetRepository);
    }

    @Test
    public void create() {
        Asset createAsset = AssetFactory.createAsset("0024", "7855", "Latitude E5400",
                2000.00);
        assets.add(assetRepository.create(createAsset));
        Assert.assertEquals(createAsset.getAssetNumber(), assetRepository.read(createAsset.getAssetId()).getAssetNumber());
    }

    @Test
    public void read() {
        Asset readAsset = assetRepository.read(asset.getAssetId());
        Assert.assertEquals(readAsset.getAssetId(), assetRepository.read(readAsset.getAssetId()).getAssetId());
    }

    @Test
    public void update() {
        String newAssetNumber = "5555";
        Asset updateAsset = new Asset.Builder().copy(asset).assetNumber(newAssetNumber).build();
        assets.add(assetRepository.update(updateAsset));
        Assert.assertEquals(updateAsset, assetRepository.read(updateAsset.getAssetId()));
    }

    @Test
    public void delete() {
        Asset deleteAsset = AssetFactory.createAsset("4444", "9856", "Deep Freeze",
                250.00);
        assets.add(assetRepository.create(deleteAsset));
        assets.remove(deleteAsset);
        assetRepository.delete(deleteAsset.getAssetId());
        Assert.assertEquals(assets.size(), assetRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Asset> assetSet = assetRepository.getAll();
        Assert.assertEquals(assetSet, assetRepository.getAll());
    }
}*/
