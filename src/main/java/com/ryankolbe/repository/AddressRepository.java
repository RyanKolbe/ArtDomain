package com.ryankolbe.repository;

import com.ryankolbe.model.Address;

import java.util.Set;

public interface AddressRepository extends IRepository<Address, String>{
    Set<Address> getAll();
}