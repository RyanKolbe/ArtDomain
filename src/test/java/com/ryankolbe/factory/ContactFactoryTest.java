package com.ryankolbe.factory;

import com.ryankolbe.model.Contact;
import org.junit.Assert;
import org.junit.Test;

public class ContactFactoryTest {

    @Test
    public void createContact() {
        Contact contact = ContactFactory.createContact("Email", "lindiv@vectorlog.com");
        Assert.assertNotNull(contact);
    }
}