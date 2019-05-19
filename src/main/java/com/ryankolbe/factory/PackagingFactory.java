package com.ryankolbe.factory;

import com.ryankolbe.domain.Packaging;

public class PackagingFactory {

    public static Packaging createPackaging(String packagingId, String packagingHeight, String packagingWidth,
                                            String packagingLength) {
        return new Packaging.Builder()
                .packagingId(packagingId)
                .packagingHeight(packagingHeight)
                .packagingWidth(packagingWidth)
                .packagingLength(packagingLength)
                .build();
    }
}