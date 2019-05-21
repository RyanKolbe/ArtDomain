package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.repository.GalleryRepository;
import com.ryankolbe.repository.implementation.GalleryRepositoryImpl;
import com.ryankolbe.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("GalleryServiceImpl")
public class GalleryServiceImpl implements GalleryService {
    private final GalleryRepository galleryRepository;

    private GalleryServiceImpl() {
        this.galleryRepository = GalleryRepositoryImpl.getGalleryRepository();
    }

    @Override
    public Set<Gallery> getAll() {
        return this.galleryRepository.getAll();
    }

    @Override
    public Gallery create(Gallery gallery) {
        return this.galleryRepository.create(gallery);
    }

    @Override
    public Gallery read(String galleryId) {
        return this.galleryRepository.read(galleryId);
    }

    @Override
    public Gallery update(Gallery gallery) {
        return this.galleryRepository.update(gallery);
    }

    @Override
    public void delete(String galleryId) {
        this.galleryRepository.delete(galleryId);
    }
}