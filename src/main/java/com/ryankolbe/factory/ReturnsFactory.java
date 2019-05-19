package com.ryankolbe.factory;

import com.ryankolbe.domain.Returns;

public class ReturnsFactory {

    public static Returns createReturns(String returnId, String returnReason, int returnQty, double returnValue) {
        return new Returns.Builder()
                .returnId(returnId)
                .returnReason(returnReason)
                .returnQty(returnQty)
                .returnValue(returnValue)
                .build();
    }
}