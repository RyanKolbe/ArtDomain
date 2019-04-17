package com.ryankolbe.factory;

import com.ryankolbe.model.Payment;
import com.ryankolbe.util.Misc;

import java.math.BigDecimal;

public class PaymentFactory {
    public static Payment createPayment(String paymentType, BigDecimal paymentValue, String paymentdate,
                                        String customerId) {
        return new Payment.Builder()
                .id(Misc.generateId())
                .paymentType(paymentType)
                .paymentValue(paymentValue)
                .paymentDate(paymentdate)
                .customerId(customerId)
                .build();
    }
}