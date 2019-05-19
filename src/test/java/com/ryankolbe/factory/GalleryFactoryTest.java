package com.ryankolbe.factory;

import com.ryankolbe.domain.Gallery;
import org.junit.Assert;
import org.junit.Test;

public class GalleryFactoryTest {

    @Test
    public void createGallery() {
        Gallery gallery = new GalleryFactory().createGallery("Hope Springs", "10",
                "Trumpet Street", "7945");
        Assert.assertEquals("Hope Springs", gallery.getGalleryName());
    }
}