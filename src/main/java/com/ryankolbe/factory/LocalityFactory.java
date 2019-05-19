package com.ryankolbe.factory;

import com.ryankolbe.domain.Locality;

public class LocalityFactory {

    public static Locality createLocality(String localizationId, String registeredName, String province, String country,
                                          String postalCode) {
        return new Locality.Builder()
                .localizationId(localizationId)
                .registeredName(registeredName)
                .province(province)
                .country(country)
                .postalCode(postalCode)
                .build();
    }
}