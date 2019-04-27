package com.ryankolbe.factory;

import com.ryankolbe.model.Contact;
import com.ryankolbe.util.Misc;

public class ContactFactory {

    public static Contact createContact(String contactNumber, String contactNumberType, String emailAddress) {
        return new Contact.Builder()
                .contactId(Misc.generateId())
                .contactNumber(contactNumber)
                .contactNumberType(contactNumberType)
                .emailAddress(emailAddress)
                .build();
    }
}