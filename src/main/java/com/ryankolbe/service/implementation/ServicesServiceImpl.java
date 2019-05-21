package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Services;
import com.ryankolbe.repository.ServicesRepository;
import com.ryankolbe.repository.implementation.ServicesRepositoryImpl;
import com.ryankolbe.service.ServicesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ServicesServiceImpl")
public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepository servicesRepository;

    private ServicesServiceImpl() {
        this.servicesRepository = ServicesRepositoryImpl.getServicesRepository();
    }

    @Override
    public Set<Services> getAll() {
        return this.servicesRepository.getAll();
    }

    @Override
    public Services create(Services services) {
        return this.servicesRepository.create(services);
    }

    @Override
    public Services read(String servicesId) {
        return this.servicesRepository.read(servicesId);
    }

    @Override
    public Services update(Services services) {
        return this.servicesRepository.update(services);
    }

    @Override
    public void delete(String servicesId) {
        this.servicesRepository.delete(servicesId);
    }
}