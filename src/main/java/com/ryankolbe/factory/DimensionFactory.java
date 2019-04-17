package com.ryankolbe.factory;

import com.ryankolbe.model.Dimension;

public class DimensionFactory {

    public static Dimension createDimension(String height, String width, String length) {
        return new Dimension.Builder()
                .height(height)
                .width(width)
                .length(length)
                .build();
    }
}