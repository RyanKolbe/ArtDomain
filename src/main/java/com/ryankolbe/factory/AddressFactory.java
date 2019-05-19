package com.ryankolbe.factory;

import com.ryankolbe.domain.Address;

public class AddressFactory {

    public static Address createAddress(String addressId, String streetNumber, String streetName, String streetType) {
        return new Address.Builder()
                .addressId(addressId)
                .streetNumber(streetNumber)
                .streetName(streetName)
                .streetType(streetType)
                .build();
    }
}
