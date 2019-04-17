package com.ryankolbe.factory;

import com.ryankolbe.model.Dimension;
import org.junit.Assert;
import org.junit.Test;

public class DimensionFactoryTest {

    @Test
    public void createDimension() {
        Dimension dimension = DimensionFactory.createDimension("1.5", "1.0", "0.5");
        Assert.assertNotNull(dimension);
    }
}