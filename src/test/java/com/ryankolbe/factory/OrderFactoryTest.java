package com.ryankolbe.factory;

import com.ryankolbe.model.Order;
import com.ryankolbe.util.Misc;
import org.junit.Assert;
import org.junit.Test;

public class OrderFactoryTest {

    @Test
    public void createOrder() {
        Order order = OrderFactory.createOrder(Misc.generateId(), "0001");
        Assert.assertNotNull(order);
    }
}