package com.ryankolbe.factory;

import com.ryankolbe.domain.Returns;
import org.junit.Assert;
import org.junit.Test;

public class ReturnsFactoryTest {

    @Test
    public void createReturns() {
        Returns returns = ReturnsFactory.createReturns("0001", "Quality", 1,
                20000.00);
        Assert.assertEquals("Quality", returns.getReturnReason());
    }
}