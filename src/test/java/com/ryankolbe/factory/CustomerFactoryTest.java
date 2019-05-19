package com.ryankolbe.factory;

import com.ryankolbe.domain.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerFactoryTest {

    @Test
    public void createCustomer() {
        Customer customer = CustomerFactory.createCustomer("0001", "Eric", "0612341000");
        Assert.assertEquals("Eric", customer.getCustomerName());
    }
}