package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.repository.CourierRepository;
import com.ryankolbe.repository.implementation.CourierRepositoryImpl;
import com.ryankolbe.service.CourierService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CourierServiceImpl")
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;

    private CourierServiceImpl() {
        this.courierRepository = CourierRepositoryImpl.getCourierRepository();
    }

    @Override
    public Set<Courier> getAll() {
        return this.courierRepository.getAll();
    }

    @Override
    public Courier create(Courier courier) {
        return this.courierRepository.create(courier);
    }

    @Override
    public Courier read(String courierId) {
        return this.courierRepository.read(courierId);
    }

    @Override
    public Courier update(Courier courier) {
        return this.courierRepository.update(courier);
    }

    @Override
    public void delete(String courierId) {
        this.courierRepository.delete(courierId);
    }
}