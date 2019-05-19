package com.ryankolbe.factory;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.util.Misc;

public class ArtFormFactory {

    public static Painting createArtForm(String artFormType, String artFormStyle) {
        return new Painting.Builder()
                .paintingId(Misc.generateId())
                .paintingName(artFormType)
                .paintingType(artFormStyle)
                .build();
    }
}