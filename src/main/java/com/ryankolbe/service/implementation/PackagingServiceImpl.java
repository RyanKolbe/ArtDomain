package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Packaging;
import com.ryankolbe.repository.PackagingRepository;
import com.ryankolbe.repository.implementation.PackagingRepositoryImpl;
import com.ryankolbe.service.PackagingService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PackagingServiceImpl")
public class PackagingServiceImpl implements PackagingService {
    private final PackagingRepository packagingRepository;

    private PackagingServiceImpl() {
        this.packagingRepository = PackagingRepositoryImpl.getPackagingRepository();
    }

    @Override
    public Set<Packaging> getAll() {
        return this.packagingRepository.getAll();
    }

    @Override
    public Packaging create(Packaging packaging) {
        return this.packagingRepository.create(packaging);
    }

    @Override
    public Packaging read(String packagingId) {
        return this.packagingRepository.read(packagingId);
    }

    @Override
    public Packaging update(Packaging packaging) {
        return this.packagingRepository.update(packaging);
    }

    @Override
    public void delete(String packagingId) {
        this.packagingRepository.delete(packagingId);
    }
}