package com.ryankolbe.factory;

import com.ryankolbe.model.Address;
import com.ryankolbe.util.Misc;

public class AddressFactory {

    public static Address createAddress(String streetNumber, String streetName, String streetType) {
        return new Address.Builder()
                .addressId(Misc.generateId())
                .streetNumber(streetNumber)
                .streetName(streetName)
                .streetType(streetType)
                .build();
    }
}
