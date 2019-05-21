package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.repository.ArtistRepository;
import com.ryankolbe.repository.implementation.ArtistRepositoryImpl;
import com.ryankolbe.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ArtistServiceImpl")
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    private ArtistServiceImpl() {
        this.artistRepository = ArtistRepositoryImpl.getArtistRepository();
    }

    @Override
    public Set<Artist> getAll() {
        return this.artistRepository.getAll();
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
}