package com.ryankolbe.repository.implementation;

import com.ryankolbe.domain.Address;
import com.ryankolbe.repository.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AddressRepository")
public class AddressRepositoryImpl implements AddressRepository {
    private static AddressRepository addressRepository = null;
    private Set<Address> addresses;

    private AddressRepositoryImpl() {
        this.addresses = new HashSet<>();
    }

    public static AddressRepository getAddressRepository() {
        if (addressRepository == null) addressRepository = new AddressRepositoryImpl();
        return addressRepository;
    }

    @Override
    public Address create(Address address) {
        this.addresses.add(address);
        return address;
    }

    @Override
    public Address read(String addressId) {
        return search(addressId);
    }

    @Override
    public Address update(Address address) {
        Address addressTemp = search(address.getAddressId());
        if (addressTemp != null) {
            Address addressNew = new Address.Builder()
                    .copy(addressTemp)
                    .build();
            return create(addressNew);
        }
        return null;
    }

    @Override
    public void delete(String addressId) {
        Address address = search(addressId);
        if (address != null) this.addresses.remove(address);
    }

    private Address search(final String addressId) {
        for (Address addressSearch : this.addresses) {
            if (addressSearch.getAddressId().equals(addressId))
                return addressSearch;
        }
        return null;
    }

    @Override
    public Set<Address> getAll() {
        return this.addresses;
    }
}