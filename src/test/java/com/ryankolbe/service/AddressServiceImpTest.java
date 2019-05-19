package com.ryankolbe.service;

import com.ryankolbe.factory.AddressFactory;
import com.ryankolbe.domain.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceImpTest {
    private Address address;
    @Qualifier("AddressServiceImp")
    private AddressService addressService;

    @Before
    public void setUp() {
        addressService = AddressServiceImp.getAddressService();
        address = AddressFactory.createAddress("0005","10", "Trumpet",
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
                "0004","15", "Marble", "Close"));
        Assert.assertNotNull(newAddress);
        Assert.assertSame(newAddress, addressService.read(newAddress.getAddressId()));
    }

    @Test
    public void read() {
        Address readTestAddress = addressService.create(AddressFactory.createAddress(
                "0006","25", "Tulip", "Crescent"));
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