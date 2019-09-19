/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.repository.LocalityRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("LocalityRepository")
public class LocalityRepositoryImpl implements LocalityRepository {
    private static LocalityRepositoryImpl localityRepository = null;
    private Set<Locality> localities;


    private LocalityRepositoryImpl() {
        this.localities = new HashSet<>();
    }

    public static LocalityRepositoryImpl getLocalityRepository() {
        if (localityRepository == null) localityRepository = new LocalityRepositoryImpl();
        return localityRepository;
    }

    @Override
    public Locality create(Locality locality) {
        this.localities.add(locality);
        return locality;
    }

    @Override
    public Locality read(String localityId) {
        return search(localityId);
    }

    @Override
    public Locality update(Locality locality) {
        Locality localityTemp = search(locality.getLocalizationId());
        if (localityTemp != null) {
            localities.remove(localityTemp);
            return create(locality);
        }
        return null;
    }

    @Override
    public void delete(String localityId) {
        Locality localityDelete = search(localityId);
        if (localityDelete != null) this.localities.remove(localityDelete);
    }

    private Locality search(final String localityId) {
        for (Locality localitySearch : this.localities) {
            if (localitySearch.getLocalizationId().equals(localityId))
                return localitySearch;
        }
        return null;
    }

    @Override
    public Set<Locality> getAll() {
        return this.localities;
    }
}*/
