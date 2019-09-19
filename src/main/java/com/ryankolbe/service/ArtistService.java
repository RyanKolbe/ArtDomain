package com.ryankolbe.service;

import com.ryankolbe.domain.Artist;

import java.util.List;

public interface ArtistService extends IService<Artist, String> {
    List<Artist> getAll();
}