package com.ryankolbe.factory;

import com.ryankolbe.domain.Artist;

public class ArtistFactory {

    public static Artist createArtist(String artistId, String artistName, String artistSurname) {
        return new Artist.Builder()
                .artistId(artistId)
                .artistName(artistName)
                .artistSurname(artistSurname)
                .build();
    }
}
