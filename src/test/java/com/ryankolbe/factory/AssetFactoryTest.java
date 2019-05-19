package com.ryankolbe.factory;

import com.ryankolbe.domain.Asset;
import org.junit.Assert;
import org.junit.Test;

public class AssetFactoryTest {

    @Test
    public void createAsset() {
        Asset asset = AssetFactory.createAsset("0001", "1234", "KL235-00",
                10000.00);
        Assert.assertEquals("1234", asset.getAssetNumber());
    }
}