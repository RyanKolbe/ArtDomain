package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ArtistFactoryTest {

    @Test
    public void createArtist() {
        Name name = NameFactory.createName("Ryan", "Fabian", "Kolbe");
        Address address = AddressFactory.createAddress("10", "Trumpet",
                "Street");
        Locality locality = LocalityFactory.createLocality("Steenberg",
                "Western Cape", "South Africa", "7945");
        Contact contact = ContactFactory.createContact("0219597000",
                "Landline", "ryank@gmail.com");
        Artist artist = ArtistFactory.createArtist(name, address, locality, contact);

        Assert.assertNotNull(artist);
        Assert.assertEquals("Ryan", artist.getName().getFirstName());
        Assert.assertEquals("Trumpet", artist.getAddress().getStreetName());
        Assert.assertEquals("Steenberg", artist.getLocality().getRegisteredName());
        Assert.assertEquals("0219597000", artist.getContact().getContactNumber());
    }
}