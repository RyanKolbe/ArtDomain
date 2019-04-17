package com.ryankolbe.factory;

import com.ryankolbe.model.Painting;
import org.junit.Assert;
import org.junit.Test;

public class PaintingFactoryTest {

    @Test
    public void createPainting() {
        Painting painting = PaintingFactory.createPainting("Victorian", "Water Paint");
        Assert.assertNotNull(painting);
    }
}