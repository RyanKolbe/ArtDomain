package com.ryankolbe.factory;

import com.ryankolbe.model.Address;
import com.ryankolbe.util.Misc;

public class AddressFactory {

    public static Address createAddress(String postalCode, String suburb) {
        return new Address.Builder()
                .addressId(Misc.generateId())
                .postalCode(postalCode)
                .suburb(suburb)
                .build();
    }
}
