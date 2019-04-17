package com.ryankolbe.factory;

import com.ryankolbe.model.Artist;
import org.junit.Assert;
import org.junit.Test;

public class ArtistFactoryTest {

    @Test
    public void createArtist() {
        Artist a = ArtistFactory.createArtist("Lindi",25,"Cape Town");
        Assert.assertEquals("Lindi",  a.getName());
    }
}