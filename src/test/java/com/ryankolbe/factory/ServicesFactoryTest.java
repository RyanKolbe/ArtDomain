package com.ryankolbe.factory;

import com.ryankolbe.domain.Services;
import org.junit.Assert;
import org.junit.Test;

public class ServicesFactoryTest {

    @Test
    public void createServices() {
        Services services = ServicesFactory.createServices("0001", "Restoration",
                "Art Restoration", 2000.00);
        Assert.assertEquals("Restoration", services.getServiceName());
    }
}