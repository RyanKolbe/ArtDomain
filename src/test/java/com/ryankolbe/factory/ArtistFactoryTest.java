package com.ryankolbe.factory;

import com.ryankolbe.domain.Artist;
import org.junit.Assert;
import org.junit.Test;

public class ArtistFactoryTest {

    @Test
    public void createArtist() {
        Artist artist = ArtistFactory.createArtist("0001", "Ryan", "Kolbe");
        Assert.assertEquals("Ryan", artist.getArtistName());
    }
}