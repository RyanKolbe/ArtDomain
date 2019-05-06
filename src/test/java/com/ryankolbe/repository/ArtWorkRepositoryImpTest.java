package com.ryankolbe.repository;

import com.ryankolbe.factory.ArtFormFactory;
import com.ryankolbe.factory.ArtworkFactory;
import com.ryankolbe.factory.CalendarFactory;
import com.ryankolbe.factory.DimensionFactory;
import com.ryankolbe.model.Artwork;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtWorkRepositoryImpTest {

    private static ArtWorkRepository artWorkRepository = ArtWorkRepositoryImp.getArtWorkRepository();
    private static Artwork artwork;
    private static Set<Artwork> artworks = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        artwork = ArtworkFactory.createArtwork(
                ArtFormFactory.createArtForm("Painting", "Gothic"),
                DimensionFactory.createDimension("2.0", "0.5", "1.0"),
                CalendarFactory.createCalendar(LocalDate.parse("2017-12-02"), LocalTime.parse("10:12:32"),
                        Year.parse("2017")));
        artworks.add(artWorkRepository.create(artwork));

        artwork = ArtworkFactory.createArtwork(
                ArtFormFactory.createArtForm("Sculpture", "Egyptian"),
                DimensionFactory.createDimension("1.5", "0.5", "0.5"),
                CalendarFactory.createCalendar(LocalDate.parse("1860-12-02"), LocalTime.parse("10:12:32"),
                        Year.parse("1860")));
        artworks.add(artWorkRepository.create(artwork));
    }

    @Test
    public void getArtWorkRepository() {
        Assert.assertNotNull(artWorkRepository);
    }

    @Test
    public void create() {
        artwork = ArtworkFactory.createArtwork(
                ArtFormFactory.createArtForm("Sculpture", "Venetian"),
                DimensionFactory.createDimension("1.8", "0.75", "0.5"),
                CalendarFactory.createCalendar(LocalDate.parse("2018-07-16"), LocalTime.parse("10:12:32"),
                        Year.parse("2018")));
        artworks.add(artWorkRepository.create(artwork));
        Assert.assertSame(artwork, artWorkRepository.read(artwork.getArtworkId()));
    }

    @Test
    public void read() {
        Artwork readArtwork = ArtworkFactory.createArtwork(
                ArtFormFactory.createArtForm("Sculpture", "Venetian"),
                DimensionFactory.createDimension("1.8", "0.75", "0.5"),
                CalendarFactory.createCalendar(LocalDate.parse("2018-07-16"), LocalTime.parse("10:12:32"),
                        Year.parse("2018")));
        artworks.add(artWorkRepository.create(readArtwork));

        Assert.assertSame(readArtwork, artWorkRepository.read(readArtwork.getArtworkId()));
    }

    @Test
    public void update() {
        String artworkId = Misc.generateId();
        Artwork artworkTemp = new Artwork.Builder()
                .copy(artwork).artworkId(artworkId).build();
        Assert.assertSame(artworkId, artworkTemp.getArtworkId());
    }

    @Test
    public void delete() {
        artworks.addAll(artWorkRepository.getAll());
        artWorkRepository.delete(artwork.getArtworkId());
        Assert.assertEquals(artworks.size() - 1, artWorkRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Artwork> artworks = artWorkRepository.getAll();
        Assert.assertEquals(artworks.size(), artWorkRepository.getAll().size());
    }
}