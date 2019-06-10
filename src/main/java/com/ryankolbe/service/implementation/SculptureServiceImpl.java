package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Sculpture;
import com.ryankolbe.repository.SculptureRepository;
import com.ryankolbe.repository.implementation.SculptureRepositoryImpl;
import com.ryankolbe.service.SculptureService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("SculptureServiceImpl")
public class SculptureServiceImpl implements SculptureService {
    private final SculptureRepository sculptureRepository;

    private SculptureServiceImpl() {
        this.sculptureRepository = SculptureRepositoryImpl.getSculptureRepository();
    }

    @Override
    public Sculpture create(Sculpture sculpture) {
        return this.sculptureRepository.create(sculpture);
    }

    @Override
    public Sculpture read(String sculptureId) {
        return this.sculptureRepository.read(sculptureId);
    }

    @Override
    public Sculpture update(Sculpture sculpture) {
        return this.sculptureRepository.update(sculpture);
    }

    @Override
    public void delete(String sculptureId) {
        this.sculptureRepository.delete(sculptureId);
    }

    @Override
    public Set<Sculpture> getAll() {
        return this.sculptureRepository.getAll();
    }
}
