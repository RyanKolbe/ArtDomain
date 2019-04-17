package com.ryankolbe.factory;

import com.ryankolbe.model.Artwork;
import com.ryankolbe.util.Misc;

public class ArtworkFactory {

    public static Artwork createArtwork(String year, String date){
        return new Artwork.Builder()
                .id(Misc.generateId())
                .year(year)
                .date(date)
                .build();
    }
}