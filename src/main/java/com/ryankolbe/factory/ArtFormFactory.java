package com.ryankolbe.factory;

import com.ryankolbe.model.ArtForm;
import com.ryankolbe.util.Misc;

public class ArtFormFactory {

    public static ArtForm createArtForm(String artFormType, String artFormStyle) {
        return new ArtForm.Builder()
                .artFormId(Misc.generateId())
                .artFormType(artFormType)
                .artFormStyle(artFormStyle)
                .build();
    }
}