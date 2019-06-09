package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Gallery;
import com.ryankolbe.factory.GalleryFactory;
import com.ryankolbe.service.GalleryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GalleryServiceImplTest {
    @Autowired
    @Qualifier("GalleryServiceImpl")
    private GalleryService galleryService;
    private Gallery gallery;
    private Set<Gallery> galleries = new HashSet<>();

    @Before
    public void setUp() {
        gallery = galleryService.create(GalleryFactory.createGallery("0001", "New Life Gallery",
                "750"));
        galleries.add(gallery);
    }

    @Test
    public void create() {
        Gallery createGallery = galleryService.create(GalleryFactory.createGallery("0025",
                "Forgotten Worlds Galleria", "568"));
        galleries.add(createGallery);
        Assert.assertEquals(createGallery, galleryService.read(createGallery.getGalleryId()));
    }

    @Test
    public void read() {
        Gallery readGallery = galleryService.read(gallery.getGalleryId());
        Assert.assertEquals(readGallery, galleryService.read(readGallery.getGalleryId()));
    }

    @Test
    public void update() {
        String newGalleryName = "Neil and Sons";
        Gallery updateGallery = galleryService.update(new Gallery.Builder().copy(gallery)
                .galleryName(newGalleryName).build());
        galleries.add(updateGallery);
        Assert.assertEquals(updateGallery, galleryService.read(updateGallery.getGalleryId()));
    }

    @Test
    public void delete() {
        galleries.addAll(galleryService.getAll());
        Gallery deleteGallery = galleryService.create(GalleryFactory.createGallery("0024",
                "Lindi Vos Fine Art", "550"));
        galleries.add(deleteGallery);
        galleries.remove(deleteGallery);
        galleryService.delete(deleteGallery.getGalleryId());
        Assert.assertEquals(galleries.size(), galleryService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Gallery> gallerySet = galleryService.getAll();
        Assert.assertEquals(gallerySet.size(), galleryService.getAll().size());
    }
}