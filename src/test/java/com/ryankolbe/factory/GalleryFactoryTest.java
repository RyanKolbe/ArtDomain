package com.ryankolbe.factory;

import com.ryankolbe.model.Gallery;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GalleryFactoryTest {

    @Test
    public void createGallery() {
        Gallery gallery = new GalleryFactory().createGallery("Hope Springs", "10",
                "Trumpet Street", "7945");
        Assert.assertEquals("Hope Springs", gallery.getGalleryName());
    }
}