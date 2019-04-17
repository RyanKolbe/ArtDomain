package com.ryankolbe.factory;

import com.ryankolbe.model.Painting;
import com.ryankolbe.util.Misc;

public class PaintingFactory {

    public static Painting createPainting(String style, String type) {
        return new Painting.Builder()
                .id(Misc.generateId())
                .style(style)
                .type(type)
                .build();
    }
}