package com.ryankolbe.factory;

import com.ryankolbe.domain.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderFactoryTest {

    @Test
    public void createOrder() {
        Order order = OrderFactory.createOrder("0001", 2, 150.00);
        Assert.assertEquals(2, order.getOrderQty());
    }
}