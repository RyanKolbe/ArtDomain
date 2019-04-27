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
    public Artist createArtist(Artist artist) {
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
            return artistNew;
        }
        return null;
    }

    @Override
    public void delete(Artist artist) {
        this.artists.remove(artist);
    }

    public Artist search(final String artistId) {
        for (Artist artistSearch : this.artists) {
            if (artistSearch.getArtistId().equals(artistId)) ;
            return artistSearch;
        }
        return null;
    }

    public Set<Artist> getArtists() {
        return this.artists;
    }
}
