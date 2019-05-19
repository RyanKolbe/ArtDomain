package com.ryankolbe.repository;

import com.ryankolbe.domain.Address;

import java.util.Set;

public interface AddressRepository extends IRepository<Address, String>{
    Set<Address> getAll();
}