package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Services;
import com.ryankolbe.repository.ServicesRepository;
import com.ryankolbe.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ServicesServiceImpl")
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public Services create(Services services) {
        return this.servicesRepository.save(services);
    }

    @Override
    public Services read(String servicesId) {
        Optional<Services> byId = this.servicesRepository.findById(servicesId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Services update(Services services) {
        return this.servicesRepository.save(services);
    }

    @Override
    public void delete(String servicesId) {
        this.servicesRepository.deleteById(servicesId);
    }

    @Override
    public List<Services> getAll() {
        return this.servicesRepository.findAll();
    }
}