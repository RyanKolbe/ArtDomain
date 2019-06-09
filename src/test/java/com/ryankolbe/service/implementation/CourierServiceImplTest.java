package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Courier;
import com.ryankolbe.factory.CourierFactory;
import com.ryankolbe.service.CourierService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourierServiceImplTest {
    @Autowired
    @Qualifier("CourierServiceImpl")
    private CourierService courierService;
    private Courier courier;
    private Set<Courier> couriers = new HashSet<>();

    @Before
    public void setUp() {
        courier = courierService.create(CourierFactory.createCourier("0010", "DHL",
                "0216568978"));
        couriers.add(courier);
    }

    @Test
    public void create() {
        Courier createCourier = courierService.create(CourierFactory.createCourier("0026", "FedEx",
                "0214898700"));
        couriers.add(createCourier);
    }

    @Test
    public void read() {
        Courier readCourier = courierService.read(courier.getCourierId());
        Assert.assertEquals(readCourier, courierService.read(readCourier.getCourierId()));
    }

    @Test
    public void update() {
        String newCourierName = "Speed Drop";
        Courier updateCourier = courierService.update(new Courier.Builder().copy(courier)
                .courierName(newCourierName).build());
        couriers.add(updateCourier);
        Assert.assertEquals(updateCourier, courierService.read(updateCourier.getCourierId()));
    }

    @Test
    public void delete() {
        couriers.addAll(courierService.getAll());
        Courier deleteCourier = courierService.create(CourierFactory.createCourier("0256",
                "Package Ex", "0216358976"));
        couriers.add(deleteCourier);
        couriers.remove(deleteCourier);
        courierService.delete(deleteCourier.getCourierId());
        Assert.assertEquals(couriers.size(), courierService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Courier> courierSet = courierService.getAll();
        Assert.assertEquals(courierSet.size(), courierService.getAll().size());
    }
}