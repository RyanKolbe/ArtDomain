/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.factory.ArtStockFactory;
import com.ryankolbe.repository.ArtStockRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArtStockRepositoryImplTest {
    private static ArtStockRepository artStockRepository = ArtStockRepositoryImpl.getArtStockRepository();
    private static ArtStock artStock;
    private static Set<ArtStock> artStocks = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        artStock = ArtStockFactory.createArtStock("0001", " 20 mm Paintbrush", 5,
                "Paintbrush");
        artStocks.add(artStockRepository.create(artStock));
    }

    @Test
    public void getArtStockRepository() {
        Assert.assertNotNull(artStockRepository);
    }

    @Test
    public void create() {
        ArtStock createArtStock = ArtStockFactory.createArtStock("0002", "Red Paint", 4,
                "Paint");
        artStocks.add(artStockRepository.create(createArtStock));
        Assert.assertEquals(createArtStock, artStockRepository.read(createArtStock.getArtStockId()));
    }

    @Test
    public void read() {
        ArtStock readArtStock = artStockRepository.read(artStock.getArtStockId());
        Assert.assertEquals(readArtStock, artStockRepository.read(readArtStock.getArtStockId()));
    }

    @Test
    public void update() {
        int newArtStockQty = 15;
        ArtStock updateArtStock = new ArtStock.Builder().copy(artStock).artStockQty(newArtStockQty).build();
        artStocks.add(artStockRepository.update(updateArtStock));
        Assert.assertEquals(updateArtStock, artStockRepository.read(updateArtStock.getArtStockId()));
    }

    @Test
    public void delete() {
        ArtStock deleteArtStock = ArtStockFactory.createArtStock("0010", "Green Paint", 14,
                "Paint");
        artStocks.add(artStockRepository.create(deleteArtStock));
        artStocks.remove(deleteArtStock);
        artStockRepository.delete(deleteArtStock.getArtStockId());
        Assert.assertEquals(artStocks.size(), artStockRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<ArtStock> artStockSet = artStockRepository.getAll();
        Assert.assertEquals(artStockSet, artStockRepository.getAll());
    }
}*/
