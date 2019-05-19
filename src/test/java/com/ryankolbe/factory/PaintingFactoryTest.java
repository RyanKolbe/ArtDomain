package com.ryankolbe.factory;

import com.ryankolbe.domain.Painting;
import org.junit.Assert;
import org.junit.Test;

public class PaintingFactoryTest {

    @Test
    public void createPainting() {
        Painting painting = PaintingFactory.createPainting("0001", "Evolution Disguised",
                "Fine Art");
        Assert.assertEquals("Fine Art", painting.getPaintingType());
    }
}