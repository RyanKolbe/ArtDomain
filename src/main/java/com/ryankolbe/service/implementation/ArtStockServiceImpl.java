package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.ArtStock;
import com.ryankolbe.repository.ArtStockRepository;
import com.ryankolbe.service.ArtStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ArtStockServiceImpl")
public class ArtStockServiceImpl implements ArtStockService {
    @Autowired
    private ArtStockRepository artStockRepository;

    @Override
    public List<ArtStock> getAll() {
        return this.artStockRepository.findAll();
    }

    @Override
    public ArtStock create(ArtStock artStock) {
        return this.artStockRepository.save(artStock);
    }

    @Override
    public ArtStock read(String artStockId) {
        Optional<ArtStock> byId = this.artStockRepository.findById(artStockId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public ArtStock update(ArtStock artStock) {
        return this.artStockRepository.save(artStock);
    }

    @Override
    public void delete(String artStockId) {
        this.artStockRepository.deleteById(artStockId);
    }
}