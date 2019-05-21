package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.repository.LocalityRepository;
import com.ryankolbe.repository.implementation.LocalityRepositoryImpl;
import com.ryankolbe.service.LocalityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("LocalityServiceImpl")
public class LocalityServiceImpl implements LocalityService {
    private final LocalityRepository localityRepository;

    private LocalityServiceImpl() {
        this.localityRepository = LocalityRepositoryImpl.getLocalityRepository();
    }

    @Override
    public Set<Locality> getAll() {
        return this.localityRepository.getAll();
    }

    @Override
    public Locality create(Locality locality) {
        return this.localityRepository.create(locality);
    }

    @Override
    public Locality read(String localityId) {
        return this.localityRepository.read(localityId);
    }

    @Override
    public Locality update(Locality locality) {
        return this.localityRepository.update(locality);
    }

    @Override
    public void delete(String localityId) {
        this.localityRepository.delete(localityId);
    }
}