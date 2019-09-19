/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.repository.ArtStockRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ArtStockRepository")
public class ArtStockRepositoryImpl implements ArtStockRepository {
    private static ArtStockRepositoryImpl artStockRepository = null;
    private Set<ArtStock> artStocks;


    private ArtStockRepositoryImpl() {
        this.artStocks = new HashSet<>();
    }

    public static ArtStockRepositoryImpl getArtStockRepository() {
        if (artStockRepository == null) artStockRepository = new ArtStockRepositoryImpl();
        return artStockRepository;
    }

    @Override
    public ArtStock create(ArtStock artStock) {
        this.artStocks.add(artStock);
        return artStock;
    }

    @Override
    public ArtStock read(String artStockId) {
        return search(artStockId);
    }

    @Override
    public ArtStock update(ArtStock artStock) {
        ArtStock artStockTemp = search(artStock.getArtStockId());
        if (artStockTemp != null) {
            artStocks.remove(artStockTemp);
            return create(artStock);
        }
        return null;
    }

    @Override
    public void delete(String artStockId) {
        ArtStock artStockDelete = search(artStockId);
        if (artStockDelete != null) this.artStocks.remove(artStockDelete);
    }

    private ArtStock search(final String artStockId) {
        for (ArtStock artStockSearch : this.artStocks) {
            if (artStockSearch.getArtStockId().equals(artStockId))
                return artStockSearch;
        }
        return null;
    }

    @Override
    public Set<ArtStock> getAll() {
        return this.artStocks;
    }
}*/
