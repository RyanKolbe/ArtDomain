/*
package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.factory.CourierFactory;
import com.ryankolbe.repository.CourierRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourierRepositoryImplTest {
    private static CourierRepository courierRepository = CourierRepositoryImpl.getCourierRepository();
    private static Courier courier;
    private static Set<Courier> couriers = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        courier = CourierFactory.createCourier("0001","DHL","0219595467");
        couriers.add(courierRepository.create(courier));
    }

    @Test
    public void getCourierRepository() {
        Assert.assertNotNull(courierRepository);
    }

    @Test
    public void create() {
        Courier createCourier = CourierFactory.createCourier("0002", "ForwardingEx",
                "0214756897");
        couriers.add(courierRepository.create(createCourier));
        Assert.assertEquals(createCourier, courierRepository.read(createCourier.getCourierId()));
    }

    @Test
    public void read() {
        Courier readCourier = courierRepository.read(courier.getCourierId());
        Assert.assertEquals(readCourier, courierRepository.read(readCourier.getCourierId()));
    }

    @Test
    public void update() {
        String newCourierName = "FedEx";
        Courier updateCourier = new Courier.Builder().copy(courier).courierName(newCourierName).build();
        couriers.add(courierRepository.update(updateCourier));
        Assert.assertEquals(updateCourier, courierRepository.read(updateCourier.getCourierId()));
    }

    @Test
    public void delete() {
        Courier deleteCourier = CourierFactory.createCourier("2134", "FastForward",
                "0448759654");
        couriers.add(courierRepository.create(deleteCourier));
        couriers.remove(deleteCourier);
        courierRepository.delete(deleteCourier.getCourierId());
        Assert.assertEquals(couriers.size(), courierRepository.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Courier> courierSet = courierRepository.getAll();
        Assert.assertEquals(courierSet, courierRepository.getAll());
    }
}*/
