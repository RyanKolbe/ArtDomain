package com.ryankolbe.factory;

import com.ryankolbe.model.Payment;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PaymentFactoryTest {

    @Test
    public void createPayment() {
        Payment payment = PaymentFactory.createPayment("Credit Card", BigDecimal.valueOf(21000),
                "17.04.2019", "00001");
        Assert.assertNotNull(payment);
    }
}