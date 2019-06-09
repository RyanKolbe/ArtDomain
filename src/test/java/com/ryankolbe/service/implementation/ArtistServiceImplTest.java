package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Artist;
import com.ryankolbe.factory.ArtistFactory;
import com.ryankolbe.service.ArtistService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArtistServiceImplTest {
    @Autowired
    @Qualifier("ArtistServiceImpl")
    private ArtistService artistService;
    private Artist artist;
    private Set<Artist> artists = new HashSet<>();

    @Before
    public void setUp() {
        artist = artistService.create(ArtistFactory.createArtist("0005", "Denise", "Fort"));
        artists.add(artist);
    }

    @Test
    public void create() {
        artist = artistService.create(ArtistFactory.createArtist("0001",
                "Deidre", "Van Vuuren"));
        artists.add(artist);
    }

    @Test
    public void read() {
        Artist readArtist = artistService.read(artist.getArtistId());
        Assert.assertEquals(readArtist, artistService.read(readArtist.getArtistId()));
    }

    @Test
    public void update() {
        String newArtistName = "Rhea";
        Artist updateArtist = artistService.update(new Artist.Builder().copy(artist).artistName(newArtistName).build());
        artists.add(updateArtist);
        Assert.assertEquals(updateArtist, artistService.read(updateArtist.getArtistId()));
    }

    @Test
    public void delete() {
        artists.addAll(artistService.getAll());
        Artist deleteArtist = artistService.create(ArtistFactory.createArtist("5468", "Ronnel",
                "Bagwandeen"));
        artists.add(deleteArtist);
        artists.remove(deleteArtist);
        artistService.delete(deleteArtist.getArtistId());
        Assert.assertEquals(artists.size(), artistService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Artist> artistSet = artistService.getAll();
        Assert.assertEquals(artistSet.size(), artistService.getAll().size());
    }
}