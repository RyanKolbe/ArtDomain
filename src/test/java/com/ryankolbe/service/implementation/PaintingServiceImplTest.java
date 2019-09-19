package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.factory.PaintingFactory;
import com.ryankolbe.service.PaintingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PaintingServiceImplTest {
    @Autowired
    @Qualifier("PaintingServiceImpl")
    private PaintingService paintingService;
    private Painting painting;
    private Set<Painting> paintings = new HashSet<>();

    @Before
    public void setUp() {
        painting = paintingService.create(PaintingFactory.createPainting("0001", "Death by Tonality",
                "Oil Painting"));
        paintings.add(painting);
    }

    @Test
    public void create() {
        Painting createPainting = paintingService.create(PaintingFactory.createPainting("0002",
                "Irridescent Night", "Water Colour Painting"));
        paintings.add(createPainting);
        Assert.assertEquals(createPainting, paintingService.read(createPainting.getPaintingId()));
    }

    @Test
    public void read() {
        Painting readPainting = paintingService.read(painting.getPaintingId());
        Assert.assertEquals(readPainting, paintingService.read(readPainting.getPaintingId()));
    }

    @Test
    public void update() {
        String newPaintingType = "Spray Painting";
        Painting updatePainting = paintingService.update(new Painting.Builder().copy(painting)
                .paintingType(newPaintingType).build());
        paintings.add(updatePainting);
        Assert.assertEquals(updatePainting, paintingService.read(updatePainting.getPaintingId()));
    }

    @Test
    public void delete() {
        paintings.addAll(paintingService.getAll());
        Painting deletePainting = paintingService.create(PaintingFactory.createPainting("0024",
                "Dusk Replaces Day", "Modern Art"));
        paintings.add(deletePainting);
        paintings.remove(deletePainting);
        paintingService.delete(deletePainting.getPaintingId());
        Assert.assertEquals(paintings.size(), paintingService.getAll().size());
    }

    @Test
    public void getAll() {
        List<Painting> paintingSet = paintingService.getAll();
        Assert.assertEquals(paintingSet.size(), paintingService.getAll().size());
    }
}