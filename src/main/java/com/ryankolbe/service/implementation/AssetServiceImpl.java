package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Asset;
import com.ryankolbe.repository.AssetRepository;
import com.ryankolbe.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AssetServiceImpl")
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Override
    public List<Asset> getAll() {
        return this.assetRepository.findAll();
    }

    @Override
    public Asset create(Asset asset) {
        return this.assetRepository.save(asset);
    }

    @Override
    public Asset read(String assetId) {
        Optional<Asset> byId = this.assetRepository.findById(assetId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Asset update(Asset asset) {
        return this.assetRepository.save(asset);
    }

    @Override
    public void delete(String assetId) {
        this.assetRepository.deleteById(assetId);
    }
}