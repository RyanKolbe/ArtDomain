package com.ryankolbe.factory;

import com.ryankolbe.domain.Contact;
import org.junit.Assert;
import org.junit.Test;

public class ContactFactoryTest {

    @Test
    public void createContact() {
        Contact contact = ContactFactory.createContact("0001", "ryank@gmail.com",
                "083083000", "0219597000");
        Assert.assertEquals("0001", contact.getContactId());
    }
}