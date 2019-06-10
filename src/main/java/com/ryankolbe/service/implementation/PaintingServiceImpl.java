package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.repository.PaintingRepository;
import com.ryankolbe.repository.implementation.PaintingRepositoryImpl;
import com.ryankolbe.service.PaintingService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PaintingServiceImpl")
public class PaintingServiceImpl implements PaintingService {
    private final PaintingRepository paintingRepository;

    private PaintingServiceImpl() {
        this.paintingRepository = PaintingRepositoryImpl.getPaintingRepository();
    }

    @Override
    public Painting create(Painting painting) {
        return this.paintingRepository.create(painting);
    }

    @Override
    public Painting read(String paintingId) {
        return this.paintingRepository.read(paintingId);
    }

    @Override
    public Painting update(Painting painting) {
        return this.paintingRepository.update(painting);
    }

    @Override
    public void delete(String paintingId) {
        this.paintingRepository.delete(paintingId);
    }

    @Override
    public Set<Painting> getAll() {
        return this.paintingRepository.getAll();
    }
}
