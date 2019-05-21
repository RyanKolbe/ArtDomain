package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Address;
import com.ryankolbe.repository.AddressRepository;
import com.ryankolbe.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
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