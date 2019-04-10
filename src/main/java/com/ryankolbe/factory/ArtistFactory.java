package com.ryankolbe.factory;

import com.ryankolbe.model.Artist;

public class ArtistFactory {

    public static Artist createArtist(String id, String name, int age, String location) {
        return new Artist.Builder()
                .id(id)
                .name(name)
                .age(age)
                .location(location)
                .build();
    }
}
