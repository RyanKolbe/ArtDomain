package com.ryankolbe.factory;

import com.ryankolbe.model.Address;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest {

    @Test
    public void createAddress() {
        Address address = AddressFactory.createAddress("7945","Steenberg");
        Assert.assertNotNull(address);
    }
}