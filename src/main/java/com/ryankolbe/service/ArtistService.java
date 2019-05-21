package com.ryankolbe.service;

import com.ryankolbe.domain.Artist;

import java.util.Set;

public interface ArtistService extends IService<Artist, String> {
    Set<Artist> getAll();
}