package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.repository.PackagingRepository;
import com.ryankolbe.service.PackagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PackagingServiceImpl")
public class PackagingServiceImpl implements PackagingService {
    @Autowired
    private PackagingRepository packagingRepository;

    @Override
    public List<Packaging> getAll() {
        return this.packagingRepository.findAll();
    }

    @Override
    public Packaging create(Packaging packaging) {
        return this.packagingRepository.save(packaging);
    }

    @Override
    public Packaging read(String packagingId) {
        Optional<Packaging> byId = this.packagingRepository.findById(packagingId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Packaging update(Packaging packaging) {
        return this.packagingRepository.save(packaging);
    }

    @Override
    public void delete(String packagingId) {
        this.packagingRepository.deleteById(packagingId);
    }
}