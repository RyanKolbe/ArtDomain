package com.ryankolbe.service;

import com.ryankolbe.factory.AddressFactory;
import com.ryankolbe.model.Address;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceImpTest {
    private static AddressService addressService;
    private static Address address;

    @BeforeClass
    public static void setUp() {
        addressService = AddressServiceImp.getAddressService();
        address = AddressFactory.createAddress("10", "Trumpet",
                "Street");
        addressService.create(address);
    }

    @Test
    public void getAddressService() {
        Assert.assertNotNull(addressService);
    }

    @Test
    public void create() {
        Address newAddress = addressService.create(AddressFactory.createAddress(
                "15", "Marble", "Close"));
        Assert.assertNotNull(newAddress);
        Assert.assertSame(newAddress, addressService.read(newAddress.getAddressId()));
    }

    @Test
    public void read() {
        Address readTestAddress = addressService.create(AddressFactory.createAddress(
                "25", "Tulip", "Crescent"));
        Assert.assertSame(readTestAddress, addressService.read(readTestAddress.getAddressId()));
    }

    @Test
    public void update() {
        String newStreetName = "Ralph";
        Address addressTemp = new Address.Builder().copy(address).streetName(newStreetName).build();
        Assert.assertSame(newStreetName, addressTemp.getStreetName());
    }

    @Test
    public void delete() {
        Address deleteAddress = addressService.getAll().stream().findFirst().orElse(null);
        int size = addressService.getAll().size();
        assert deleteAddress != null;
        addressService.delete(deleteAddress.getAddressId());
        Assert.assertEquals(size - 1, addressService.getAll().size());
    }
}