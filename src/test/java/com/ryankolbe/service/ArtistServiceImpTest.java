package com.ryankolbe.service;

import com.ryankolbe.factory.*;
import com.ryankolbe.model.Artist;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtistServiceImpTest {
    private static ArtistService artistService;
    private static Artist artist;

    @BeforeClass
    public static void setUp() {
        artistService = ArtistServiceImp.getArtistService();
        artist = ArtistFactory.createArtist(NameFactory.createName("Deidre", "Rochelle",
                "Van Vuuren"),
                AddressFactory.createAddress("10", "Trumpet", "Street"),
                LocalityFactory.createLocality("Steenberg", "Western Cape",
                        "South Africa", "7945"),
                ContactFactory.createContact("0219597000", "Landline",
                        "deidrevanvuuren@gmail.com"));

        artistService.create(artist);
    }

    @Test
    public void create() {
        Artist newCreateArtist = artistService.create(artistService.getAll().stream().findFirst().orElse(null));
        Assert.assertNotNull(newCreateArtist);
        Assert.assertSame(newCreateArtist, artistService.read(artistService.getAll().iterator().next().getArtistId()));
    }

    @Test
    public void read() {
        Artist artistTemp = ArtistFactory.createArtist(NameFactory.createName("Ryan", "Fabian",
                "Kolbe"),
                AddressFactory.createAddress("10", "Trumpet", "Street"),
                LocalityFactory.createLocality("Steenberg", "Western Cape",
                        "South Africa", "7945"),
                ContactFactory.createContact("0219597000", "Landline",
                        "ryank@gmail.com"));
        artistService.create(artistTemp);

        Assert.assertSame(artistTemp, artistService.read(artistTemp.getArtistId()));
    }

    @Test
    public void update() {
        String artistId = Misc.generateId();
        Artist newArtist = new Artist.Builder().copy(artist).artistId(artistId).build();

        Assert.assertSame(artistId, newArtist.getArtistId());
    }

    @Test
    public void delete() {
        Artist deleteArtist = artistService.getAll().stream().findFirst().orElse(null);
        int size = artistService.getAll().size();
        assert deleteArtist != null;
        artistService.delete(deleteArtist.getArtistId());
        size -= 1;
        Assert.assertEquals(size, artistService.getAll().size());
    }
}