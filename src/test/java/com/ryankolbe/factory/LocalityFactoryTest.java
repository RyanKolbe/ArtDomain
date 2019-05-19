package com.ryankolbe.factory;

import com.ryankolbe.domain.Locality;
import org.junit.Assert;
import org.junit.Test;

public class LocalityFactoryTest {

    @Test
    public void createLocality() {
        Locality locality = LocalityFactory.createLocality("0001", "Randburg",
                "Gauteng", "South Africa", "8000");
        Assert.assertEquals("Gauteng", locality.getProvince());
    }
}