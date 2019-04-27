package com.ryankolbe.repository;

import com.ryankolbe.factory.*;
import com.ryankolbe.model.*;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArtistRepositoryImplTest {
    private static Artist artist;
    private static Name name;
    private static Address address;
    private static Locality locality;
    private static Contact contact;
    private static List<Artist> artistList;
    private static ArtistRepository artistRepository;
    private static Set<Artist> artistSet; //new addition.

    @BeforeClass
    public static void setUp() throws Exception {
        artist = ArtistFactory.createArtist();
        name = NameFactory.createName("Ryan", "Fabian", "Kolbe");
        address = AddressFactory.createAddress("10", "Trumpet", "Street");
        locality = LocalityFactory.createLocality("Steenberg", "Western Cape",
                "South Africa", "7945");
        contact = ContactFactory.createContact("0219597000", "Landline",
                "ryank@gmail.com");
        artistList = new ArrayList<>();
        artistSet = new HashSet<>();

        artistList.add(new Artist.Builder()
                .artistId(Misc.generateId())
                .name(name)
                .address(address)
                .locality(locality)
                .contact(contact)
                .build());
        artistRepository = ArtistRepositoryImpl.getArtistRepository();
        artistRepository.update(artistList.get(0));
        artistRepository.read(artistList.get(0).getArtistId());
    }

    @Ignore @Test
    public void getArtistRepository() {
        System.out.println(artistRepository);
        Assert.assertNotNull(artistRepository);
    }

    @Ignore @Test
    public void createArtist() {
        name = NameFactory.createName("Deidre", "Rochelle", "Van Vuuren");
        address = AddressFactory.createAddress("10", "Trumpet", "Street");
        locality = LocalityFactory.createLocality("Steenberg", "Western Cape",
                "South Africa", "7945");
        contact = ContactFactory.createContact("0219597000", "Landline",
                "deidrevanvuuren@gmail.com");

        artist = ArtistFactory.createArtist();
        Artist artist = artistRepository.createArtist(new Artist.Builder()
                .artistId(Misc.generateId())
                .name(name)
                .address(address)
                .locality(locality)
                .contact(contact)
                .build());
        Assert.assertEquals(name.getFirstName(), artist.getName().getFirstName());
        System.out.println(artistRepository.read(artist.getArtistId()));
    }

    @Test
    public void read() {
        System.out.println(artist.getName());
//        Assert.assertEquals("Deidre", artist.getName());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {

    }

    @Test
    public void search() {
    }

    @Ignore
    @Test
    public void getArtists() {
        System.out.println(artistRepository.read(artistList.get(0).getArtistId()));
    }
}