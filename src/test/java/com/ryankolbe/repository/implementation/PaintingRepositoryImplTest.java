package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.factory.PaintingFactory;
import com.ryankolbe.repository.PaintingRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaintingRepositoryImplTest {
    private static PaintingRepository paintingRepository = PaintingRepositoryImpl.getPaintingRepository();
    private static Painting painting;
    private static Set<Painting> paintings = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        painting = PaintingFactory.createPainting("0001", "Midnight Sun?",
                "Oil");
        paintings.add(paintingRepository.create(painting));
    }

    @Test
    public void getPaintingRepository() {
        Assert.assertNotNull(paintingRepository);
    }

    @Test
    public void create() {
        Painting createPainting = PaintingFactory.createPainting("0248", "Misconstrued Love",
                "Charcoal");
        paintings.add(paintingRepository.create(createPainting));
        Assert.assertEquals(createPainting, paintingRepository.read(createPainting.getPaintingId()));
    }

    @Test
    public void read() {
        Painting readPainting = paintingRepository.read(painting.getPaintingId());
        Assert.assertEquals(readPainting, paintingRepository.read(readPainting.getPaintingId()));
    }

    @Test
    public void update() {
        String newPaintingName = "Under The Cove";
        Painting updatePainting = new Painting.Builder().copy(painting).paintingName(newPaintingName).build();
        paintings.add(paintingRepository.update(updatePainting));
        Assert.assertEquals(updatePainting, paintingRepository.read(updatePainting.getPaintingId()));
    }

    @Test
    public void delete() {
        Painting deletePainting = PaintingFactory.createPainting("09547", "Inappropriate Intent",
                "Water");
        paintings.add(paintingRepository.create(deletePainting));
        paintings.remove(deletePainting);
        paintingRepository.delete(deletePainting.getPaintingId());
        Assert.assertEquals(paintings.size(),paintingRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Painting> paintingSet = paintingRepository.getAll();
        Assert.assertEquals(paintingSet.size(), paintingRepository.getAll().size());
    }
}