package com.ryankolbe.service;

import com.ryankolbe.domain.Address;

import java.util.Set;

public interface AddressService extends IService<Address, String> {
    Set<Address> getAll();
}