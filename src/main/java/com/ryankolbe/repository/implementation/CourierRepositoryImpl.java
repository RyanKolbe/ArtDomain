package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.repository.CourierRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CourierRepository")
public class CourierRepositoryImpl implements CourierRepository {
    private static CourierRepositoryImpl courierRepository = null;
    private Set<Courier> couriers;


    private CourierRepositoryImpl() {
        this.couriers = new HashSet<>();
    }

    public static CourierRepositoryImpl getCourierRepository() {
        if (courierRepository == null) courierRepository = new CourierRepositoryImpl();
        return courierRepository;
    }

    @Override
    public Courier create(Courier courier) {
        this.couriers.add(courier);
        return courier;
    }

    @Override
    public Courier read(String courierId) {
        return search(courierId);
    }

    @Override
    public Courier update(Courier courier) {
        Courier courierTemp = search(courier.getCourierId());
        if (courierTemp != null) {
            return create(new Courier.Builder()
                    .copy(courierTemp)
                    .build());
        }
        return null;
    }

    @Override
    public void delete(String courierId) {
        Courier courierDelete = search(courierId);
        if (courierDelete != null) this.couriers.remove(courierDelete);
    }

    private Courier search(final String courierId) {
        for (Courier courierSearch : this.couriers) {
            if (courierSearch.getCourierId().equals(courierId))
                return courierSearch;
        }
        return null;
    }

    @Override
    public Set<Courier> getAll() {
        return this.couriers;
    }
}