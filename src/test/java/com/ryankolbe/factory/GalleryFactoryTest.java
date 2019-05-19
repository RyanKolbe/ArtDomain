package com.ryankolbe.factory;

import com.ryankolbe.domain.Gallery;
import org.junit.Assert;
import org.junit.Test;

public class GalleryFactoryTest {

    @Test
    public void createGallery() {
        Gallery gallery = GalleryFactory.createGallery("00001", "Hope Springs", "100");
        Assert.assertEquals("Hope Springs", gallery.getGalleryName());
    }
}