package com.ryankolbe.repository;

import com.ryankolbe.model.Gallery;

import java.util.Set;

public interface GalleryRepository extends IRepository<Gallery, String> {
    Set<Gallery> getAll();
}
