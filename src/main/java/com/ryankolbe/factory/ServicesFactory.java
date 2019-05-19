package com.ryankolbe.factory;

import com.ryankolbe.domain.Services;

public class ServicesFactory {

    public static Services createServices(String serviceId, String serviceName, String serviceType,
                                          double serviceCost) {
        return new Services.Builder()
                .serviceId(serviceId)
                .serviceName(serviceName)
                .serviceType(serviceType)
                .serviceCost(serviceCost)
                .build();
    }
}