package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.repository.PaintingRepository;
import com.ryankolbe.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PaintingServiceImpl")
public class PaintingServiceImpl implements PaintingService {
    @Autowired
    private PaintingRepository paintingRepository;

    @Override
    public Painting create(Painting painting) {
        return this.paintingRepository.save(painting);
    }

    @Override
    public Painting read(String paintingId) {
        Optional<Painting> byId = this.paintingRepository.findById(paintingId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Painting update(Painting painting) {
        return this.paintingRepository.save(painting);
    }

    @Override
    public void delete(String paintingId) {
        this.paintingRepository.deleteById(paintingId);
    }

    @Override
    public List<Painting> getAll() {
        return this.paintingRepository.findAll();
    }
}