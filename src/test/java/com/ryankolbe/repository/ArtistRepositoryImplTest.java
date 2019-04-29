package com.ryankolbe.repository;

import com.ryankolbe.factory.*;
import com.ryankolbe.model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ArtistRepositoryImplTest {

    private static ArtistRepository artistRepository;
    private static Artist artist;
    private static Artist ryan;
    private static Set<Artist> artists = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        artistRepository = ArtistRepositoryImpl.getArtistRepository();

        Name name = NameFactory.createName("Deidre", "Rochelle", "Van Vuuren");
        Address address = AddressFactory.createAddress("10", "Trumpet", "Street");
        Locality locality = LocalityFactory.createLocality("Steenberg", "Western Cape",
                "South Africa", "7945");
        Contact contact = ContactFactory.createContact("0219597000", "Landline",
                "deidrevanvuuren@gmail.com");

        artist = ArtistFactory.createArtist(name, address, locality, contact);
        artists.add(artistRepository.create(artist));
    }

    @Test
    public void createArtist() {
        Name name = NameFactory.createName("Ryan", "Fabian", "Kolbe");
        Address address = AddressFactory.createAddress("10", "Trumpet", "Street");
        Locality locality = LocalityFactory.createLocality("Steenberg", "Western Cape",
                "South Africa", "7945");
        Contact contact = ContactFactory.createContact("0219597000", "Landline",
                "ryank@gmail.com");

        ryan = ArtistFactory.createArtist(name, address, locality, contact);
        artists.add(artistRepository.create(ryan));
        Assert.assertEquals(ryan, artistRepository.read(ryan.getArtistId()));
    }

    @Test
    public void read() {
        Assert.assertEquals(artist, artistRepository.read(artist.getArtistId()));
    }

    @Test
    public void update() {
        Artist deidre = artistRepository.update(artist);
        Assert.assertEquals(artist,deidre);
    }

    @Test
    public void delete() {
        Artist deidre = artistRepository.read(artist.getArtistId());
        artistRepository.delete(deidre.getArtistId());
        Assert.assertNotSame(deidre,artistRepository);
    }

    @Test
    public void search() {
    }

    @Test
    public void getArtists() {
    }
}