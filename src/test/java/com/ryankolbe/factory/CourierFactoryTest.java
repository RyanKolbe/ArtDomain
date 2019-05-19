package com.ryankolbe.factory;

import com.ryankolbe.domain.Courier;
import org.junit.Assert;
import org.junit.Test;

public class CourierFactoryTest {

    @Test
    public void createCourier() {
        Courier courier = CourierFactory.createCourier("0001", "DHL", "0218001234");
        Assert.assertEquals("DHL", courier.getCourierName());
    }
}