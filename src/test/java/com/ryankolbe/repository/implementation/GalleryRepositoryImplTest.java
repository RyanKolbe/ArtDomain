package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.factory.GalleryFactory;
import com.ryankolbe.repository.GalleryRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GalleryRepositoryImplTest {
    private static GalleryRepository galleryRepository = GalleryRepositoryImpl.getGalleryRepository();
    private static Gallery gallery;
    private static Set<Gallery> galleries = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        gallery = GalleryFactory.createGallery("0001", "Retreat Modern Art", "5000");
        galleries.add(galleryRepository.create(gallery));
    }

    @Test
    public void getGalleryRepository() {
        Assert.assertNotNull(galleryRepository);
    }

    @Test
    public void create() {
        Gallery createGallery = GalleryFactory.createGallery("0002", "Steenberg Lifestyle Centre",
                "406");
        galleries.add(galleryRepository.create(createGallery));
        Assert.assertEquals(createGallery, galleryRepository.read(createGallery.getGalleryId()));
    }

    @Test
    public void read() {
        Gallery readGallery = galleryRepository.read(gallery.getGalleryId());
        Assert.assertEquals(readGallery, galleryRepository.read(readGallery.getGalleryId()));
    }

    @Test
    public void update() {
        String newGalleryName = "Stone Heart Company";
        Gallery updateGallery = new Gallery.Builder().copy(gallery).galleryName(newGalleryName).build();
        galleries.add(galleryRepository.update(updateGallery));
        Assert.assertEquals(updateGallery, galleryRepository.read(updateGallery.getGalleryId()));
    }

    @Test
    public void delete() {
        Gallery deleteGallery = GalleryFactory.createGallery("0014", "Van Vuuren Natural Art",
                "1000");
        galleries.add(galleryRepository.create(deleteGallery));
        galleries.remove(deleteGallery);
        galleryRepository.delete(deleteGallery.getGalleryId());
        Assert.assertEquals(galleries.size(), galleryRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Gallery> gallerySet = galleryRepository.getAll();
        Assert.assertEquals(gallerySet, galleryRepository.getAll());
    }
}