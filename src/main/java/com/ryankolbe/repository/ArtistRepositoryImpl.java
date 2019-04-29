package com.ryankolbe.repository;

import com.ryankolbe.model.Artist;

import java.util.HashSet;
import java.util.Set;

public class ArtistRepositoryImpl implements ArtistRepository {
    private static ArtistRepository artistRepository = null;
    private Set<Artist> artists;

    private ArtistRepositoryImpl() {
        this.artists = new HashSet<>();
    }

    public static ArtistRepository getArtistRepository() {
        if (artistRepository == null) artistRepository = new ArtistRepositoryImpl();
        return artistRepository;
    }

    @Override
    public Artist create(Artist artist) {
        this.artists.add(artist);
        return artist;

    }

    @Override
    public Artist read(final String artistId) {
        return search(artistId);
    }

    @Override
    public Artist update(Artist artist) {
        Artist artistTemp = search(artist.getArtistId());
        if (artistTemp != null) {
            Artist artistNew = new Artist.Builder()
                    .copy(artistTemp)
                    .build();
            return create(artistNew);
        }
        return null;
    }

    @Override
    public void delete(String artistId) {
        this.artists.remove(artistId);

    }

    public Set<Artist> getArtists() {
        return this.artists;
    }

    public Artist search(final String artistId) {
        for (Artist artistSearch : this.artists) {
            if (artistSearch.getArtistId().equals(artistId)) ;
            return artistSearch;
        }
        return null;
    }
}
