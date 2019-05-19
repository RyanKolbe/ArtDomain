package com.ryankolbe.factory;

import com.ryankolbe.domain.Curator;
import org.junit.Assert;
import org.junit.Test;

public class CuratorFactoryTest {

    @Test
    public void createCurator() {
        Curator curator = CuratorFactory.createCurator("0001", "Baldwin", "Meyers");
        Assert.assertEquals("Baldwin", curator.getCuratorName());
    }
}