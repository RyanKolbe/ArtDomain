package com.ryankolbe.factory;

import com.ryankolbe.model.Locality;
import org.junit.Assert;
import org.junit.Test;

public class LocalityFactoryTest {

    @Test
    public void createAddress() {
        Locality locality = LocalityFactory.createLocality("Steenberg", "Western Cape",
                "South Africa", "7945");
        Assert.assertEquals("Steenberg",locality.getRegisteredName());
    }
}