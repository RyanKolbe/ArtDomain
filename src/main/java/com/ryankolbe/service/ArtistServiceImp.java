package com.ryankolbe.service;

import com.ryankolbe.model.Artist;
import com.ryankolbe.repository.ArtistRepositoryImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashSet;
import java.util.Set;

public class ArtistServiceImp implements ArtistService {

    private static ArtistService artistService = null;
    private ArtistRepositoryImpl artistRepository;
    private Set<Artist> artistSet;

    private ArtistServiceImp(){
        this.artistSet = new HashSet<>();
    }

    public static ArtistService getArtistService(){
        if (artistService == null) artistService = new ArtistServiceImp();
        return artistService;
    }

    @Override
    public Artist createArtist(Artist artist) {
        return this.artistRepository.createArtist(artist);
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
    public void delete(
            Artist artist) {
        return null;

    }
}
