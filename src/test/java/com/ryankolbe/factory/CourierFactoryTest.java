package com.ryankolbe.factory;

import com.ryankolbe.model.Courier;
import org.junit.Assert;
import org.junit.Test;

public class CourierFactoryTest {

    @Test
    public void createCourier() {
        Courier courier = CourierFactory.createCourier("Globeflight");
        Assert.assertNotNull(courier);
    }
}