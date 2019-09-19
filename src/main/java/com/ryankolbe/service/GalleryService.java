package com.ryankolbe.service;

import com.ryankolbe.domain.Gallery;

import java.util.List;

public interface GalleryService extends IService<Gallery, String> {
    List<Gallery> getAll();
}