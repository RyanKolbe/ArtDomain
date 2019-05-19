package com.ryankolbe.factory;

import com.ryankolbe.domain.Address;
import org.junit.Assert;
import org.junit.Test;

public class AddressFactoryTest {

    @Test
    public void createAddress() {
        Address address = AddressFactory.createAddress("10", "Trumpet",
                "Street");
        Assert.assertEquals("Trumpet",address.getStreetName());
    }
}