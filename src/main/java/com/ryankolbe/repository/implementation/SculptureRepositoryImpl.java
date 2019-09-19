/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Sculpture;
import com.ryankolbe.repository.SculptureRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("SculptureRepository")
public class SculptureRepositoryImpl implements SculptureRepository {
    private static SculptureRepositoryImpl sculptureRepository = null;
    private Set<Sculpture> sculptures;


    private SculptureRepositoryImpl() {
        this.sculptures = new HashSet<>();
    }

    public static SculptureRepositoryImpl getSculptureRepository() {
        if (sculptureRepository == null) sculptureRepository = new SculptureRepositoryImpl();
        return sculptureRepository;
    }

    @Override
    public Sculpture create(Sculpture sculpture) {
        this.sculptures.add(sculpture);
        return sculpture;
    }

    @Override
    public Sculpture read(String sculptureId) {
        return search(sculptureId);
    }

    @Override
    public Sculpture update(Sculpture sculpture) {
        Sculpture sculptureTemp = search(sculpture.getSculptureId());
        if (sculptureTemp != null) {
            sculptures.remove(sculptureTemp);
            return create(sculpture);
        }
        return null;
    }

    @Override
    public void delete(String sculptureId) {
        Sculpture sculptureDelete = search(sculptureId);
        if (sculptureDelete != null) this.sculptures.remove(sculptureDelete);
    }

    private Sculpture search(final String sculptureId) {
        for (Sculpture sculptureSearch : this.sculptures) {
            if (sculptureSearch.getSculptureId().equals(sculptureId))
                return sculptureSearch;
        }
        return null;
    }

    @Override
    public Set<Sculpture> getAll() {
        return this.sculptures;
    }
}*/
