package com.ryankolbe.repository;

import com.ryankolbe.domain.Customer;

import java.util.Set;

public interface CustomerRepository extends IRepository<Customer, String> {
    Set<Customer> getAll();
}