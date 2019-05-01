package com.ryankolbe.repository.implementation;

import com.ryankolbe.factory.AddressFactory;
import com.ryankolbe.model.Address;
import com.ryankolbe.repository.AddressRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressRepositoryImplTest {

    private static AddressRepository addressRepository = AddressRepositoryImpl.getAddressRepository();
    private static Address address;
    private static Set<Address> addresses = new HashSet<>();

    @BeforeClass
    public static void setUp() {
        address = AddressFactory.createAddress("10", "Trumpet", "Street");
        addresses.add(addressRepository.create(address));
    }

    @Test
    public void create() {
        address = AddressFactory.createAddress("15", "Niger", "Road");
        addresses.add(addressRepository.create(address));

        Assert.assertEquals("Niger", address.getStreetName());
    }

    @Test
    public void read() {
        address = AddressFactory.createAddress("15", "Niger", "Road");
        addresses.add(addressRepository.create(address));

        Assert.assertEquals("Niger", addressRepository.read(address.getAddressId()).getStreetName());
    }

    @Test
    public void update() {
        String newStreetName = "Berkley";
        Address newAddress = new Address.Builder().copy(address).streetName(newStreetName).build();
        Assert.assertEquals(newStreetName, newAddress.getStreetName());
    }

    @Test
    public void delete() {
        address = AddressFactory.createAddress("21", "Melody", "Close");
        addresses.add(addressRepository.create(address));
        addressRepository.delete(address.getAddressId());

        Assert.assertEquals(2, addressRepository.getAll().size());
    }
}