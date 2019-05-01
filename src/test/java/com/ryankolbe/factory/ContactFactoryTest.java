package com.ryankolbe.factory;

import com.ryankolbe.model.Contact;
import org.junit.Assert;
import org.junit.Test;

public class ContactFactoryTest {

    @Test
    public void createContact() {
        Contact contact = ContactFactory.createContact("0219597000", "Landline",
                "lindiv@vectorlog.com");
        Assert.assertEquals("0219597000",contact.getContactNumber());
    }
}