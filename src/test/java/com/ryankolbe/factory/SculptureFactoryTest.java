package com.ryankolbe.factory;

import com.ryankolbe.model.Sculpture;
import org.junit.Assert;
import org.junit.Test;

public class SculptureFactoryTest {

    @Test
    public void createSculpture() {
        Sculpture sculpture = SculptureFactory.createSculpture("Clay", "0.8", "1.5");
        Assert.assertNotNull(sculpture);
    }
}