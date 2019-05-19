package com.ryankolbe.factory;

import com.ryankolbe.domain.Locality;
import com.ryankolbe.util.Misc;

public class LocalityFactory {

    public static Locality createLocality(String registeredName, String province, String country,
                                          String postalCode) {
        return new Locality.Builder()
                .localizationId(Misc.generateId())
                .registeredName(registeredName)
                .province(province)
                .country(country)
                .postalCode(postalCode)
                .build();
    }
}
