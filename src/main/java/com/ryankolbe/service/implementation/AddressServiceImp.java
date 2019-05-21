package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Address;
import com.ryankolbe.repository.AddressRepository;
import com.ryankolbe.repository.implementation.AddressRepositoryImpl;
import com.ryankolbe.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AddressServiceImp")
public class AddressServiceImp implements AddressService {

    @Autowired
    @Qualifier("AddressServiceImp")
    private static AddressServiceImp addressService;
    private AddressRepository addressRepository;

    private AddressServiceImp() {
        this.addressRepository = AddressRepositoryImpl.getAddressRepository();
    }

    public static AddressService getAddressService(){
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