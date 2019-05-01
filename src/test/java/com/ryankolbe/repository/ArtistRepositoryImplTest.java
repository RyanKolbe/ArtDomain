package com.ryankolbe.repository;

import com.ryankolbe.factory.*;
import com.ryankolbe.model.Artist;
import com.ryankolbe.model.Name;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
        System.out.println(artistRepository.getAll());

        artist = ArtistFactory.createArtist(NameFactory.createName("Cassidy", "",
                "Van Vuuren"),
                AddressFactory.createAddress("10", "Trumpet", "Street"),
                LocalityFactory.createLocality("Steenberg", "Western Cape",
                        "South Africa", "7945"),
                ContactFactory.createContact("0219597000", "Landline",
                        "cassidyv@gmail.com"));

        artists.add(artistRepository.create(artist));

        artistRepository.create(artist);

        Assert.assertEquals(3, artistRepository.getAll().size());
    }

    @Test
    public void read() {
        String artistId = artists.iterator().next().getArtistId();
        String artistIdCheck = artistRepository.read(artistId).getArtistId();
        Assert.assertEquals(artistId, artistIdCheck);
    }

    @Test
    public void update() {
        String newFirstName = "Elizabeth";
        Artist artist = new Name.Builder().copy(artists).firstName(newFirstName).build();
        artistRepository.update(artist);

    }

    @Test
    public void delete() {
        artistRepository.delete(artist.getArtistId());
        Assert.assertEquals(1,artistRepository.getAll().size());
    }

    @Test
    public void getArtists() {
        Set<Artist> testSet = artistRepository.getAll();
        System.out.println(testSet.size());
        Assert.assertEquals(artistRepository.getAll().size(),testSet.size());
    }
}