package com.ryankolbe.factory;

import com.ryankolbe.model.Name;

public class NameFactory {

    public static Name createName(String firstName, String middleName, String lastName) {
        return new Name.Builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();
    }
}
