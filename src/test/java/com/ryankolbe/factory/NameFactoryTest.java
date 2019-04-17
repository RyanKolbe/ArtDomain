package com.ryankolbe.factory;

import com.ryankolbe.model.Name;
import org.junit.Assert;
import org.junit.Test;

public class NameFactoryTest {

    @Test
    public void createName() {
        Name name = NameFactory.createName("Ryan", "Fabian", "Kolbe");
        Assert.assertNotNull(name);
    }
}