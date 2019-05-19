package com.ryankolbe.factory;

import com.ryankolbe.domain.Order;

public class OrderFactory {

    public static Order createOrder(String orderId, int orderQty, double orderValue) {
        return new Order.Builder()
                .orderId(orderId)
                .orderQty(orderQty)
                .orderValue(orderValue)
                .build();
    }
}