package com.ryankolbe.service;

import com.ryankolbe.model.Address;

import java.util.Set;

public interface AddressService extends IService<Address, String> {
    Set<Address> getAll();
}
