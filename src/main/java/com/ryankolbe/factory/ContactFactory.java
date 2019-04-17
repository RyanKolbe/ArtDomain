package com.ryankolbe.factory;

import com.ryankolbe.model.Contact;
import com.ryankolbe.util.Misc;

public class ContactFactory {

    public static Contact createContact(String contactMethod, String contactDetails) {
        return new Contact.Builder()
                .id(Misc.generateId())
                .contactMethod(contactMethod)
                .contactDetails(contactDetails)
                .build();
    }
}