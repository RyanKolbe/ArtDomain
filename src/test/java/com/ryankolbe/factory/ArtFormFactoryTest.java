package com.ryankolbe.factory;

import com.ryankolbe.model.ArtForm;
import org.junit.Assert;
import org.junit.Test;

public class ArtFormFactoryTest {

    @Test
    public void createArtForm() {
        ArtForm artForm = ArtFormFactory.createArtForm("Painting", "Modern Art");
        Assert.assertEquals("Painting",artForm.getArtFormType());
    }
}