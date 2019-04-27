package com.ryankolbe.factory;

import com.ryankolbe.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ArtistFactoryTest {

    @Test
    public void createArtist() {
        Artist artist = ArtistFactory.createArtist();
        Name name = NameFactory.createName("Ryan", "Fabian", "Kolbe");
        Address address = AddressFactory.createAddress("10", "Trumpet",
                "Street");
        Locality locality = LocalityFactory.createLocality("Steenberg",
                "Western Cape", "South Africa", "7945");
        Contact contact = ContactFactory.createContact("0219597000",
                "Landline", "ryank@gmail.com");

        Assert.assertNotNull(artist);
        Assert.assertEquals("Ryan", name.getFirstName());
        Assert.assertEquals("Trumpet", address.getStreetName());
        Assert.assertEquals("Steenberg", locality.getRegisteredName());
        Assert.assertEquals("0219597000", contact.getContactNumber());
    }
}