package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.factory.ArtStockFactory;
import com.ryankolbe.service.ArtStockService;
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
public class ArtStockServiceImplTest {
    @Autowired
    @Qualifier("ArtStockServiceImpl")
    private ArtStockService artStockService;
    private ArtStock artStock;
    private Set<ArtStock> artStocks = new HashSet<>();

    @Before
    public void setUp() {
        artStock = artStockService.create(ArtStockFactory.createArtStock("0356", "Charcoal",
                6, "Drawing Supplies"));
        artStocks.add(artStock);
    }

    @Test
    public void create() {
        ArtStock createArtStock = artStockService.create(ArtStockFactory.createArtStock("0001",
                "20 mm Paint brush", 2, "Paint brush"));
        artStocks.add(createArtStock);
    }

    @Test
    public void read() {
        ArtStock readArtStock = artStockService.read(artStock.getArtStockId());
        Assert.assertEquals(readArtStock, artStockService.read(readArtStock.getArtStockId()));
    }

    @Test
    public void update() {
        String newArtStockName = "Chisel";
        ArtStock updateArtStock = artStockService.update(new ArtStock.Builder().copy(artStock).
                artStockName(newArtStockName).build());
        artStocks.add(updateArtStock);
        Assert.assertEquals(updateArtStock, artStockService.read(updateArtStock.getArtStockId()));
    }

    @Test
    public void delete() {
        artStocks.addAll(artStockService.getAll());
        ArtStock deleteArtStock = artStockService.create(ArtStockFactory.createArtStock("0265",
                "Clay", 6, "Pottery Clay"));
        artStocks.add(deleteArtStock);
        artStocks.remove(deleteArtStock);
        artStockService.delete(deleteArtStock.getArtStockId());
        Assert.assertEquals(artStocks.size(), artStockService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<ArtStock> artStockSet = artStockService.getAll();
        Assert.assertEquals(artStockSet.size(), artStockService.getAll().size());
    }
}