package com.ryankolbe.factory;

import com.ryankolbe.model.City;
import com.ryankolbe.util.Misc;

public class CityFactory {

    public static City createCity(String postalCode, String city) {
        return new City.Builder()
                .id(Misc.generateId())
                .postalCode(postalCode)
                .city(city)
                .build();
    }
}
