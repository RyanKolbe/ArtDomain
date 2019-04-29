package com.ryankolbe.service;

import com.ryankolbe.model.Artist;

public interface ArtistService {
    Artist create(Artist artist);

    Artist read(String artistId);

    Artist update(Artist artist);

    void delete(String artistId);
}
