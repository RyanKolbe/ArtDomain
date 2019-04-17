package com.ryankolbe.factory;

import com.ryankolbe.model.Customer;
import com.ryankolbe.util.Misc;

public class CustomerFactory {

    public static Customer createCustomer(String customerName, String customerAddress, String customerEmail,
                                          String customerPassword, String customerUsername) {
        return new Customer.Builder()
                .id(Misc.generateId())
                .customerName(customerName)
                .customerAddress(customerAddress)
                .customerEmail(customerEmail)
                .customerPassword(customerPassword)
                .customerUsername(customerUsername)
                .build();
    }
}