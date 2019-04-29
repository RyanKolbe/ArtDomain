package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import com.ryankolbe.util.Misc;

public class ArtworkFactory {

    public static Artwork createArtwork(ArtForm artForm, Dimension dimension, Calendar calendar) {
        return new Artwork.Builder()
                .artworkId(Misc.generateId())
                .artForm(artForm)
                .dimension(dimension)
                .calendar(calendar)
                .build();
    }
}