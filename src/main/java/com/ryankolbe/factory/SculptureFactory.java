package com.ryankolbe.factory;

import com.ryankolbe.domain.Sculpture;

public class SculptureFactory {

    public static Sculpture createSculpture(String sculptureId, String sculptureName, String sculptureType) {
        return new Sculpture.Builder()
                .sculptureId(sculptureId)
                .sculptureName(sculptureName)
                .sculpureType(sculptureType)
                .build();
    }
}