package com.ryankolbe.factory;

import com.ryankolbe.domain.Customer;

public class CustomerFactory {

    public static Customer createCustomer(String customerId, String customerName, String customerCell) {
        return new Customer.Builder()
                .customerId(customerId)
                .customerName(customerName)
                .customerCell(customerCell)
                .build();
    }
}