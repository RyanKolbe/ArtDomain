package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.repository.LocalityRepository;
import com.ryankolbe.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("LocalityServiceImpl")
public class LocalityServiceImpl implements LocalityService {
    @Autowired
    private LocalityRepository localityRepository;

    @Override
    public Locality create(Locality locality) {
        return this.localityRepository.save(locality);
    }

    @Override
    public Locality read(String localityId) {
        Optional<Locality> byId = this.localityRepository.findById(localityId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Locality update(Locality locality) {
        return this.localityRepository.save(locality);
    }

    @Override
    public void delete(String localityId) {
        this.localityRepository.deleteById(localityId);
    }

    @Override
    public List<Locality> getAll() {
        return this.localityRepository.findAll();
    }
}