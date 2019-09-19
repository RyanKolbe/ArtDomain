/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Painting;
import com.ryankolbe.repository.PaintingRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("PaintingRepository")
public class PaintingRepositoryImpl implements PaintingRepository {
    private static PaintingRepositoryImpl paintingRepository = null;
    private Set<Painting> paintings;


    private PaintingRepositoryImpl() {
        this.paintings = new HashSet<>();
    }

    public static PaintingRepositoryImpl getPaintingRepository() {
        if (paintingRepository == null) paintingRepository = new PaintingRepositoryImpl();
        return paintingRepository;
    }

    @Override
    public Painting create(Painting painting) {
        this.paintings.add(painting);
        return painting;
    }

    @Override
    public Painting read(String paintingId) {
        return search(paintingId);
    }

    @Override
    public Painting update(Painting painting) {
        Painting paintingTemp = search(painting.getPaintingId());
        if (paintingTemp != null) {
            paintings.remove(paintingTemp);
            return create(painting);
        }
        return null;
    }

    @Override
    public void delete(String paintingId) {
        Painting paintingDelete = search(paintingId);
        if (paintingDelete != null) this.paintings.remove(paintingDelete);
    }

    private Painting search(final String paintingId) {
        for (Painting paintingSearch : this.paintings) {
            if (paintingSearch.getPaintingId().equals(paintingId))
                return paintingSearch;
        }
        return null;
    }

    @Override
    public Set<Painting> getAll() {
        return this.paintings;
    }
}*/
