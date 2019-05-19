package com.ryankolbe.factory;

import com.ryankolbe.domain.Painting;

public class PaintingFactory {

    public static Painting createPainting(String paintingId, String paintingName, String paintingType) {
        return new Painting.Builder()
                .paintingId(paintingId)
                .paintingName(paintingName)
                .paintingType(paintingType)
                .build();
    }
}