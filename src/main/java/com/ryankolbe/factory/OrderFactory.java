package com.ryankolbe.factory;

import com.ryankolbe.model.Order;
import com.ryankolbe.util.Misc;

public class OrderFactory {

    public static Order createOrder(String orderNumber, String customerNumber) {
        return new Order.Builder()
                .id(Misc.generateId())
                .orderNumber(orderNumber)
                .customerNumber(customerNumber)
                .build();
    }
}