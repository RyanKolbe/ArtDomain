package com.ryankolbe.factory;

import com.ryankolbe.domain.ArtStock;
import org.junit.Assert;
import org.junit.Test;

public class ArtStockFactoryTest {

    @Test
    public void createArtStock() {
        ArtStock artStock = ArtStockFactory.createArtStock("0001", "Brush", 3,
                "Paintbrush");
        Assert.assertEquals("Brush", artStock.getArtStockName());
    }
}