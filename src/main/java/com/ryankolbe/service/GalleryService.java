package com.ryankolbe.service;

import com.ryankolbe.domain.Gallery;

import java.util.Set;

public interface GalleryService extends IService<Gallery, String> {
    Set<Gallery> getAll();
}