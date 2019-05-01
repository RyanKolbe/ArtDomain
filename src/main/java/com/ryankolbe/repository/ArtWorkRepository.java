package com.ryankolbe.repository;

import com.ryankolbe.model.Artwork;

import java.util.Set;

public interface ArtWorkRepository extends IRepository<Artwork, String> {
    Set<Artwork> getAll();
}