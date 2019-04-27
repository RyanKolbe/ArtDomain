package com.ryankolbe.service;

import com.ryankolbe.model.Artist;

public interface ArtistService {
    Artist createArtist(Artist artist);

    Artist read(String artistId);

    Artist update(Artist artist);

    void delete(Artist artist);
}
