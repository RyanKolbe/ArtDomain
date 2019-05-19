package com.ryankolbe.factory;

import com.ryankolbe.domain.Courier;

public class CourierFactory {

    public static Courier createCourier(String courierId, String courierName, String courierContact) {
        return new Courier.Builder()
                .courierId(courierId)
                .courierName(courierName)
                .courierContact(courierContact)
                .build();
    }
}