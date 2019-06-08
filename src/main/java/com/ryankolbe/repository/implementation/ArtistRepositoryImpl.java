package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.repository.ArtistRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ArtistRepository")
public class ArtistRepositoryImpl implements ArtistRepository {
    private static ArtistRepositoryImpl artistRepository = null;
    private Set<Artist> artists;


    private ArtistRepositoryImpl() {
        this.artists = new HashSet<>();
    }

    public static ArtistRepositoryImpl getArtistRepository() {
        if (artistRepository == null) artistRepository = new ArtistRepositoryImpl();
        return artistRepository;
    }

    @Override
    public Artist create(Artist artist) {
        this.artists.add(artist);
        return artist;
    }

    @Override
    public Artist read(String artistId) {
        return search(artistId);
    }

    @Override
    public Artist update(Artist artist) {
        Artist artistTemp = search(artist.getArtistId());
        if (artistTemp != null) {
            artists.remove(artistTemp);
            return create(artist);
        }
        return null;
    }

    @Override
    public void delete(String artistId) {
        Artist artistDelete = search(artistId);
        if (artistDelete != null) this.artists.remove(artistDelete);
    }

    private Artist search(final String artistId) {
        for (Artist artistSearch : this.artists) {
            if (artistSearch.getArtistId().equals(artistId))
                return artistSearch;
        }
        return null;
    }

    @Override
    public Set<Artist> getAll() {
        return this.artists;
    }
}