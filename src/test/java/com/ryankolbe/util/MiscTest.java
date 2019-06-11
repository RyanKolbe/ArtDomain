package com.ryankolbe.util;

import org.junit.Assert;
import org.junit.Test;

public class MiscTest {

    @Test
    public void generateId() {
        String randomId = Misc.generateId();
        Assert.assertNotEquals(randomId, Misc.generateId());
    }
}