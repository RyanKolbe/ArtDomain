package com.ryankolbe.repository.implementation;

import com.ryankolbe.model.Artist;
import com.ryankolbe.repository.ArtistRepository;

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
        Artist artist = search(artistId);
        if (artist != null) this.artists.remove(artist);
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

    @Override
    public Set<Artist> getAll() {
        return this.artists;
    }
}
