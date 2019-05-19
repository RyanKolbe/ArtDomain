package com.ryankolbe.factory;

import com.ryankolbe.domain.Gallery;

public class GalleryFactory {
    public static Gallery createGallery(String galleryId, String galleryName, String gallerySize) {
        return new Gallery.Builder()
                .galleryId(galleryId)
                .galleryName(galleryName)
                .gallerySize(gallerySize)
                .build();
    }
}