package com.ryankolbe.factory;

import com.ryankolbe.model.Artist;
import com.ryankolbe.util.Misc;

public class ArtistFactory {

    public static Artist createArtist() {
        return new Artist.Builder()
                .artistId(Misc.generateId())
                .build();
    }
}