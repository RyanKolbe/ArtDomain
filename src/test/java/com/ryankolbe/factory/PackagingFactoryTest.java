package com.ryankolbe.factory;

import com.ryankolbe.domain.Packaging;
import org.junit.Assert;
import org.junit.Test;

public class PackagingFactoryTest {

    @Test
    public void createPackaging() {
        Packaging packaging = PackagingFactory.createPackaging("0001", "450",
                "450", "1000");
        Assert.assertEquals("450", packaging.getPackagingWidth());
    }
}