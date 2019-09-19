/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.factory.ArtistFactory;
import com.ryankolbe.repository.ArtistRepository;
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
        artist = ArtistFactory.createArtist("0001", "Jacques", "Gusteau");
        artists.add(artistRepository.create(artist));
    }

    @Test
    public void getArtistRepository() {
        Assert.assertNotNull(artistRepository);
    }

    @Test
    public void create() {
        Artist createArtist = ArtistFactory.createArtist("0002", "Lindi", "Vos");
        artists.add(artistRepository.create(createArtist));
        Assert.assertEquals(createArtist, artistRepository.read(createArtist.getArtistId()));
    }

    @Test
    public void read() {
        Artist readArtist = artistRepository.read(artist.getArtistId());
        Assert.assertEquals(readArtist, artistRepository.read(readArtist.getArtistId()));
    }

    @Test
    public void update() {
        String newArtistName = "Rhea";
        Artist updateArtist = new Artist.Builder().copy(artist).artistName(newArtistName).build();
        artists.add(artistRepository.update(updateArtist));
        Assert.assertEquals(updateArtist, artistRepository.read(updateArtist.getArtistId()));
    }

    @Test
    public void delete() {
        Artist deleteArtist = ArtistFactory.createArtist("0007", "Louis", "Herman");
        artists.add(artistRepository.create(deleteArtist));
        artists.remove(deleteArtist);
        artistRepository.delete(deleteArtist.getArtistId());
        Assert.assertEquals(artists.size(), artistRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Artist> artistSet = artistRepository.getAll();
        Assert.assertEquals(artistSet, artistRepository.getAll());
    }
}*/
