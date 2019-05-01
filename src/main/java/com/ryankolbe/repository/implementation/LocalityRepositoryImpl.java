package com.ryankolbe.repository.implementation;

import com.ryankolbe.model.Locality;
import com.ryankolbe.repository.LocalityRepository;

import java.util.HashSet;
import java.util.Set;

public class LocalityRepositoryImpl implements LocalityRepository {
    private static LocalityRepository localityRepository = null;
    private Set<Locality> localities;

    private LocalityRepositoryImpl() {
        this.localities = new HashSet<>();
    }

    public static LocalityRepository getLocalityRepository() {
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
            Locality localityNew = new Locality.Builder()
                    .copy(localityTemp)
                    .build();
            return create(localityNew);
        }
        return null;
    }

    @Override
    public void delete(String localityId) {
        Locality locality = search(localityId);
        if (localityId != null) this.localities.remove(locality);
    }

    public Locality search(final String localityId) {
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
}
