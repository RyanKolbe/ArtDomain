package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.repository.GalleryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("GalleryRepository")
public class GalleryRepositoryImpl implements GalleryRepository {
    private static GalleryRepositoryImpl galleryRepository = null;
    private Set<Gallery> galleries;


    private GalleryRepositoryImpl() {
        this.galleries = new HashSet<>();
    }

    public static GalleryRepositoryImpl getGalleryRepository() {
        if (galleryRepository == null) galleryRepository = new GalleryRepositoryImpl();
        return galleryRepository;
    }

    @Override
    public Gallery create(Gallery gallery) {
        this.galleries.add(gallery);
        return gallery;
    }

    @Override
    public Gallery read(String galleryId) {
        return search(galleryId);
    }

    @Override
    public Gallery update(Gallery gallery) {
        Gallery galleryTemp = search(gallery.getGalleryId());
        if (galleryTemp != null) {
            galleries.remove(galleryTemp);
            return create(gallery);
        }
        return null;
    }

    @Override
    public void delete(String galleryId) {
        Gallery galleryDelete = search(galleryId);
        if (galleryDelete != null) this.galleries.remove(galleryDelete);
    }

    private Gallery search(final String galleryId) {
        for (Gallery gallerySearch : this.galleries) {
            if (gallerySearch.getGalleryId().equals(galleryId))
                return gallerySearch;
        }
        return null;
    }

    @Override
    public Set<Gallery> getAll() {
        return this.galleries;
    }
}