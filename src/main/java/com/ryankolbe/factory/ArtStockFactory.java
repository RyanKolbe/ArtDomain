package com.ryankolbe.factory;

import com.ryankolbe.domain.ArtStock;

public class ArtStockFactory {

    public static ArtStock createArtStock(String artStockId, String artStockName,
                                          int artStockQty, String artStockType) {
        return new ArtStock.Builder()
                .artStockId(artStockId)
                .artStockName(artStockName)
                .artStockQty(artStockQty)
                .artStockType(artStockType)
                .build();
    }
}