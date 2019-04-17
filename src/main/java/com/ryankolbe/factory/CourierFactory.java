package com.ryankolbe.factory;

import com.ryankolbe.model.Courier;
import com.ryankolbe.util.Misc;

public class CourierFactory {

    public static Courier createCourier(String courierName) {
        return new Courier.Builder()
                .id(Misc.generateId())
                .courierName(courierName)
                .build();
    }
}
