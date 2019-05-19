package com.ryankolbe.factory;

import com.ryankolbe.domain.Sculpture;
import org.junit.Assert;
import org.junit.Test;

public class SculptureFactoryTest {

    @Test
    public void createSculpture() {
        Sculpture sculpture = SculptureFactory.createSculpture("0001", "Detonated",
                "Abstract Sculpture");
        Assert.assertEquals("Detonated", sculpture.getSculptureName());
    }
}