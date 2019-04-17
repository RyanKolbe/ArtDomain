package com.ryankolbe.factory;

import com.ryankolbe.model.Gallery;
import com.ryankolbe.util.Misc;

public class GalleryFactory {
    public static Gallery createGallery(String galleryName, String galleryStreetNumber, String galleryStreetName,
                                        String galleryPostalCode) {
        return new Gallery.Builder()
                .galleryId(Misc.generateId())
                .galleryName(galleryName)
                .galleryAddress(galleryStreetNumber)
                .galleryStreetName(galleryStreetName)
                .galleryPostalCode(galleryPostalCode)
                .build();
    }
}
