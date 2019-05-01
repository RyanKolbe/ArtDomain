package com.ryankolbe.repository;

import com.ryankolbe.model.Artist;

import java.util.Set;

public interface ArtistRepository extends IRepository<Artist, String> {
    Set<Artist> getAll();

}
