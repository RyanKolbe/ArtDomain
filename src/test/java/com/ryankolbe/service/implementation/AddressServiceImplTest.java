package com.ryankolbe.service.implementation;

import com.ryankolbe.domain.Address;
import com.ryankolbe.factory.AddressFactory;
import com.ryankolbe.service.AddressService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceImplTest {
    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService addressService;
    private Address address;
    private Set<Address> addresses = new HashSet<>();

    @Before
    public void setUp() {
        address = addressService.create(AddressFactory.createAddress("0005", "10", "Trumpet",
                "Street"));
        addresses.add(address);
    }

    @Test
    public void create() {
        Address createAddress = addressService.create(AddressFactory.createAddress(
                "0004", "15", "Marble", "Close"));
        addresses.add(createAddress);
        Assert.assertEquals(createAddress, addressService.read(createAddress.getAddressId()));
    }

    @Test
    public void read() {
        Address readTestAddress = addressService.create(AddressFactory.createAddress(
                "0006", "25", "Tulip", "Crescent"));
        Assert.assertEquals(readTestAddress, addressService.read(readTestAddress.getAddressId()));
    }

    @Test
    public void update() {
        String newStreetName = "Ralph";
        Address updateAddress = addressService.update(new Address.Builder().copy(address).streetName(newStreetName).build());
        addresses.add(updateAddress);
        Assert.assertEquals(updateAddress, addressService.read(updateAddress.getAddressId()));
    }

    @Test
    public void delete() {
        addresses.addAll(addressService.getAll());
        Address deleteAddress = addressService.create(AddressFactory.createAddress("2456", "24",
                "Rubric", "Drive"));
        addresses.add(deleteAddress);
        addresses.remove(deleteAddress);
        addressService.delete(deleteAddress.getAddressId());
        Assert.assertEquals(addresses.size(), addressService.getAll().size());
    }

    @Test
    public void getAll() {
        Set<Address> addressSet = addressService.getAll();
        Assert.assertEquals(addressSet.size(), addressService.getAll().size());
    }
}