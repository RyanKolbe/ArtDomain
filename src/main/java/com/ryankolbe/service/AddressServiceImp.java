package com.ryankolbe.service;

import com.ryankolbe.model.Address;
import com.ryankolbe.repository.AddressRepository;
import com.ryankolbe.repository.AddressRepositoryImpl;

import java.util.Set;

public class AddressServiceImp implements AddressService {

    private static AddressService addressService = null;
    private AddressRepository addressRepository;

    public AddressServiceImp() {
        this.addressRepository = AddressRepositoryImpl.getAddressRepository();
    }

    public static AddressService getAddressService() {
        if (addressService == null) addressService = new AddressServiceImp();
        return addressService;
    }

    @Override
    public Set<Address> getAll() {
        return this.addressRepository.getAll();
    }

    @Override
    public Address create(Address address) {
        return this.addressRepository.create(address);
    }

    @Override
    public Address read(String addressId) {
        return this.addressRepository.read(addressId);
    }

    @Override
    public Address update(Address address) {
        return this.addressRepository.update(address);
    }

    @Override
    public void delete(String addressId) {
        this.addressRepository.delete(addressId);
    }
}