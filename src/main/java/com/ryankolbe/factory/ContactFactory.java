package com.ryankolbe.factory;

import com.ryankolbe.domain.Contact;

public class ContactFactory {

    public static Contact createContact(String contactId, String contactEmail, String contactCell,
                                        String contactLandLine) {
        return new Contact.Builder()
                .contactId(contactId)
                .contactEmail(contactEmail)
                .contactCell(contactCell)
                .contactLandLine(contactLandLine)
                .build();
    }
}