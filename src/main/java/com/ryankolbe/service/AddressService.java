package com.ryankolbe.service;

import com.ryankolbe.domain.Address;

import java.util.List;

public interface AddressService extends IService<Address, String> {
    List<Address> getAll();
}