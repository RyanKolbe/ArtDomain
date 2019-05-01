package com.ryankolbe.repository.implementation;

import com.ryankolbe.factory.*;
import com.ryankolbe.model.Artist;
import com.ryankolbe.repository.ArtistRepository;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtistRepositoryImplTest {

    private static ArtistRepository artistRepository = ArtistRepositoryImpl.getArtistRepository();
    private static Artist artist;
    private static Set<Artist> artists = new HashSet<>();

    @BeforeClass
    public static void setUp() {

        artist = ArtistFactory.createArtist(NameFactory.createName("Deidre", "Rochelle",
                "Van Vuuren"),
                AddressFactory.createAddress("10", "Trumpet", "Street"),
                LocalityFactory.createLocality("Steenberg", "Western Cape",
                        "South Africa", "7945"),
                ContactFactory.createContact("0219597000", "Landline",
                        "deidrevanvuuren@gmail.com"));

        artists.add(artistRepository.create(artist));

        artist = ArtistFactory.createArtist(NameFactory.createName("Ryan", "Fabian",
                "Kolbe"),
                AddressFactory.createAddress("10", "Trumpet", "Street"),
                LocalityFactory.createLocality("Steenberg", "Western Cape",
                        "South Africa", "7945"),
                ContactFactory.createContact("0219597000", "Landline",
                        "ryank@gmail.com"));

        artists.add(artistRepository.create(artist));
    }

    @Test
    public void createArtist() {
        artist = ArtistFactory.createArtist(NameFactory.createName("Cassidy", "",
                "Van Vuuren"),
                AddressFactory.createAddress("10", "Trumpet", "Street"),
                LocalityFactory.createLocality("Steenberg", "Western Cape",
                        "South Africa", "7945"),
                ContactFactory.createContact("0219597000", "Landline",
                        "cassidyv@gmail.com"));

        artists.add(artistRepository.create(artist));

        Assert.assertEquals(artists.size(), artistRepository.getAll().size());
    }

    @Test
    public void read() {
        String artistId = String.valueOf(artistRepository.getAll().stream().findFirst().get().getArtistId());
        String artistIdCheck = artistRepository.read(artistId).getArtistId();
        Assert.assertEquals(artistId, artistIdCheck);
    }

    @Test
    public void update() {
        String newArtistId = Misc.generateId();
        Artist newArtist = new Artist.Builder().copy(artist).artistId(newArtistId).build();
        Assert.assertEquals(newArtistId, newArtist.getArtistId());
    }

    @Test
    public void delete() {
        artistRepository.delete(artist.getArtistId());
        Assert.assertEquals(2, artistRepository.getAll().size());
    }

    @Test
    public void getArtists() {
        Set<Artist> testSet = artistRepository.getAll();
        Assert.assertEquals(artistRepository.getAll().size(), testSet.size());
    }
}