package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Services;
import com.ryankolbe.repository.ServicesRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("ServicesRepository")
public class ServicesRepositoryImpl implements ServicesRepository {
    private static ServicesRepositoryImpl servicesRepository = null;
    private Set<Services> services;


    private ServicesRepositoryImpl() {
        this.services = new HashSet<>();
    }

    public static ServicesRepositoryImpl getServicesRepository() {
        if (servicesRepository == null) servicesRepository = new ServicesRepositoryImpl();
        return servicesRepository;
    }

    @Override
    public Services create(Services services) {
        this.services.add(services);
        return services;
    }

    @Override
    public Services read(String servicesId) {
        return search(servicesId);
    }

    @Override
    public Services update(Services services) {
        Services servicesTemp = search(services.getServiceId());
        if (servicesTemp != null) {
            this.services.remove(servicesTemp);
            return create(services);
        }
        return null;
    }

    @Override
    public void delete(String servicesId) {
        Services servicesDelete = search(servicesId);
        if (servicesDelete != null) this.services.remove(servicesDelete);
    }

    private Services search(final String servicesId) {
        for (Services servicesSearch : this.services) {
            if (servicesSearch.getServiceId().equals(servicesId))
                return servicesSearch;
        }
        return null;
    }

    @Override
    public Set<Services> getAll() {
        return this.services;
    }
}