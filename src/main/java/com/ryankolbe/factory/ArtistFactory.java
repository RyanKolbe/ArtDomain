package com.ryankolbe.factory;

import com.ryankolbe.model.Artist;
import com.ryankolbe.util.Misc;

public class ArtistFactory {

    public static Artist createArtist(String name, int age, String location) {
        return new Artist.Builder()
                .id(Misc.generateId())
                .name(name)
                .age(age)
                .location(location)
                .build();
    }
}
