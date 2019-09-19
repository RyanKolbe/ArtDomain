package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.repository.CourierRepository;
import com.ryankolbe.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CourierServiceImpl")
public class CourierServiceImpl implements CourierService {
    @Autowired
    private CourierRepository courierRepository;

    @Override
    public List<Courier> getAll() {
        return this.courierRepository.findAll();
    }

    @Override
    public Courier create(Courier courier) {
        return this.courierRepository.save(courier);
    }

    @Override
    public Courier read(String courierId) {
        Optional<Courier> byId = this.courierRepository.findById(courierId);
        return byId.orElseThrow(RuntimeException::new);
    }

    @Override
    public Courier update(Courier courier) {
        return this.courierRepository.save(courier);
    }

    @Override
    public void delete(String courierId) {
        this.courierRepository.deleteById(courierId);
    }
}