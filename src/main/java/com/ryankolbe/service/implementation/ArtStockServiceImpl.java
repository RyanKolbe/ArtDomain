package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.repository.ArtStockRepository;
import com.ryankolbe.repository.implementation.ArtStockRepositoryImpl;
import com.ryankolbe.service.ArtStockService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ArtStockServiceImpl")
public class ArtStockServiceImpl implements ArtStockService {
    private final ArtStockRepository artStockRepository;

    private ArtStockServiceImpl() {
        this.artStockRepository = ArtStockRepositoryImpl.getArtStockRepository();
    }

    @Override
    public Set<ArtStock> getAll() {
        return this.artStockRepository.getAll();
    }

    @Override
    public ArtStock create(ArtStock artStock) {
        return this.artStockRepository.create(artStock);
    }

    @Override
    public ArtStock read(String artStockId) {
        return this.artStockRepository.read(artStockId);
    }

    @Override
    public ArtStock update(ArtStock artStock) {
        return this.artStockRepository.update(artStock);
    }

    @Override
    public void delete(String artStockId) {
        this.artStockRepository.delete(artStockId);
    }
}