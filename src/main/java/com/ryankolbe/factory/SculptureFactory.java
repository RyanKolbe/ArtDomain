package com.ryankolbe.factory;

import com.ryankolbe.model.Sculpture;
import com.ryankolbe.util.Misc;

public class SculptureFactory {

    public static Sculpture createSculpture(String material, String height, String weight){
        return new Sculpture.Builder()
                .id(Misc.generateId())
                .material(material)
                .height(height)
                .weight(weight)
                .build();
    }
}