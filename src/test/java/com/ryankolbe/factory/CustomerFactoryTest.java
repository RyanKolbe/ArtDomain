package com.ryankolbe.factory;

import com.ryankolbe.model.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerFactoryTest {

    @Test
    public void createCustomer() {

        Customer customer = CustomerFactory.createCustomer("Ryan", "10 Trumpet Street",
                "ryan.kolbe01@gmail.com", "*******", "*******");
        Assert.assertNotNull(customer);
    }
}