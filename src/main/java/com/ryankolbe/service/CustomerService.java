package com.ryankolbe.service;

import com.ryankolbe.domain.Customer;

import java.util.Set;

public interface CustomerService extends IService<Customer, String> {
    Set<Customer> getAll();
}