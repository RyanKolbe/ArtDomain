package com.ryankolbe.service;

import com.ryankolbe.domain.Customer;

import java.util.List;

public interface CustomerService extends IService<Customer, String> {
    List<Customer> getAll();
}