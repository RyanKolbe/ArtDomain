package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.repository.ArtistRepository;
import com.ryankolbe.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ArtistServiceImpl")
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist create(Artist artist) {
        return this.artistRepository.save(artist);
    }

    @Override
    public Artist read(String artistId) {
        Optional<Artist> byId = this.artistRepository.findById(artistId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Artist update(Artist artist) {
        return this.artistRepository.save(artist);
    }

    @Override
    public void delete(String artistId) {
        this.artistRepository.deleteById(artistId);
    }

    @Override
    public List<Artist> getAll() {
        return this.artistRepository.findAll();
    }
}