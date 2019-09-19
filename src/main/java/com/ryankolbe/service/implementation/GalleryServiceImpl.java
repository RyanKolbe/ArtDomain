package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.repository.GalleryRepository;
import com.ryankolbe.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("GalleryServiceImpl")
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public Gallery create(Gallery gallery) {
        return this.galleryRepository.save(gallery);
    }

    @Override
    public Gallery read(String galleryId) {
        Optional<Gallery> byId = this.galleryRepository.findById(galleryId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Gallery update(Gallery gallery) {
        return this.galleryRepository.save(gallery);
    }

    @Override
    public void delete(String galleryId) {
        this.galleryRepository.deleteById(galleryId);
    }

    @Override
    public List<Gallery> getAll() {
        return this.galleryRepository.findAll();
    }
}