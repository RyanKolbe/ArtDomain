package com.ryankolbe.factory;

import com.ryankolbe.model.City;
import org.junit.Assert;
import org.junit.Test;

public class CityFactoryTest {

    @Test
    public void createCity() {
        City city = CityFactory.createCity("7945", "Steenberg");
        Assert.assertNotNull(city.getCity());
    }
}