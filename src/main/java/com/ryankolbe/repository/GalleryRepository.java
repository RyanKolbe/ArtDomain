package com.ryankolbe.repository;

import com.ryankolbe.domain.Gallery;

import java.util.Set;

public interface GalleryRepository extends IRepository<Gallery, String> {
    Set<Gallery> getAll();
}
