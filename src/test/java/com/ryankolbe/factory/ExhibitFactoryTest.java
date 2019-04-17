package com.ryankolbe.factory;

import com.ryankolbe.model.Exhibit;
import org.junit.Assert;
import org.junit.Test;

public class ExhibitFactoryTest {

    @Test
    public void createExhibit() {
        Exhibit exhibit = ExhibitFactory.createExhibit("17.04.2019", "19.04.2019");
        Assert.assertNotNull(exhibit);
    }
}