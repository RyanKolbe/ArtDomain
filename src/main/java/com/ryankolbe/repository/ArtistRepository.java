package com.ryankolbe.repository;

import com.ryankolbe.model.Artist;

public interface ArtistRepository {

    Artist createArtist(Artist artist);

    Artist read(String artistId);

    Artist update(Artist artist);

    void delete(Artist artist);
}
