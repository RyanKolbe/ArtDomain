package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import com.ryankolbe.util.Misc;

public class ArtistFactory {

    public static Artist createArtist(Name name, Address address, Locality locality, Contact contact) {
        return new Artist.Builder()
                .artistId(Misc.generateId())
                .name(name)
                .address(address)
                .locality(locality)
                .contact(contact)
                .build();
    }
}