package com.ryankolbe.factory;

import com.ryankolbe.model.Artwork;
import org.junit.Assert;
import org.junit.Test;

public class ArtworkFactoryTest {

    @Test
    public void createArtwork() {
        Artwork artwork = ArtworkFactory.createArtwork("2000", "19.04.2014");
        Assert.assertNotNull(artwork);
    }
}