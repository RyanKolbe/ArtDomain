package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Sculpture;
import com.ryankolbe.repository.SculptureRepository;
import com.ryankolbe.service.SculptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SculptureServiceImpl")
public class SculptureServiceImpl implements SculptureService {
    @Autowired
    private SculptureRepository sculptureRepository;

    @Override
    public Sculpture create(Sculpture sculpture) {
        return this.sculptureRepository.save(sculpture);
    }

    @Override
    public Sculpture read(String sculptureId) {
        Optional<Sculpture> byId = this.sculptureRepository.findById(sculptureId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Sculpture update(Sculpture sculpture) {
        return this.sculptureRepository.save(sculpture);
    }

    @Override
    public void delete(String sculptureId) {
        this.sculptureRepository.deleteById(sculptureId);
    }

    @Override
    public List<Sculpture> getAll() {
        return this.sculptureRepository.findAll();
    }
}