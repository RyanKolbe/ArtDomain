package com.ryankolbe.service;

import com.ryankolbe.model.Artist;
import com.ryankolbe.repository.ArtistRepository;
import com.ryankolbe.repository.ArtistRepositoryImpl;

import java.util.Set;

public class ArtistServiceImp implements ArtistService {

    private static ArtistService artistService = null;
    private ArtistRepository artistRepository;

    private ArtistServiceImp() {
        this.artistRepository = ArtistRepositoryImpl.getArtistRepository();
    }

    public static ArtistService getArtistService() {
        if (artistService == null) artistService = new ArtistServiceImp();
        return artistService;
    }

    @Override
    public Artist create(Artist artist) {
        return this.artistRepository.create(artist);
    }

    @Override
    public Artist read(String artistId) {
        return this.artistRepository.read(artistId);
    }

    @Override
    public Artist update(Artist artist) {
        return this.artistRepository.update(artist);
    }

    @Override
    public void delete(String artistId) {
        this.artistRepository.delete(artistId);
    }

    @Override
    public Set<Artist> getAll() {
        return this.artistRepository.getAll();
    }
}
