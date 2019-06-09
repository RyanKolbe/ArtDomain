package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Asset;
import com.ryankolbe.factory.AssetFactory;
import com.ryankolbe.service.AssetService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AssetServiceImplTest {
    @Autowired
    @Qualifier("AssetServiceImpl")
    private AssetService assetService;
    private Asset asset;
    private Set<Asset> assets = new HashSet<>();

    @Before
    public void setUp() {
        asset = assetService.create(AssetFactory.createAsset("0010", "6589",
                "Latitude", 235.00));
        assets.add(asset);
    }

    @Test
    public void create() {
        Asset createAsset = assetService.create(AssetFactory.createAsset("0025", "6574",
                "Eco View", 2540.00));
        assets.add(createAsset);
        Assert.assertEquals(createAsset, assetService.read(createAsset.getAssetId()));
    }

    @Test
    public void read() {
        Asset readAsset = assetService.read(asset.getAssetId());
        Assert.assertEquals(readAsset, assetService.read(readAsset.getAssetId()));
    }

    @Test
    public void update() {
        String newAssetModel = "Extra View";
        Asset updateAsset = assetService.update(new Asset.Builder().copy(asset).assetModel(newAssetModel).build());
        assets.add(updateAsset);
        Assert.assertEquals(updateAsset, assetService.read(updateAsset.getAssetId()));
    }

    @Test
    public void delete() {
        assets.addAll(assetService.getAll());
        Asset deleteAsset = assetService.create(AssetFactory.createAsset("0465", "7468",
                "XYZ3", 653.00));
        assets.add(deleteAsset);
        assets.remove(deleteAsset);
        assetService.delete(deleteAsset.getAssetId());
        Assert.assertEquals(assets.size(), assetService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Asset> assetSet = assetService.getAll();
        Assert.assertEquals(assetSet.size(), assetService.getAll().size());
    }
}