package com.ryankolbe.repository;

import com.ryankolbe.model.Contact;

import java.util.HashSet;
import java.util.Set;

public class ContactRepositoryImp implements ContactRepository {
    private static ContactRepository contactRepository = null;
    private Set<Contact> contacts;

    private ContactRepositoryImp() {
        this.contacts = new HashSet<>();
    }

    public static ContactRepository getContactRepository() {
        if (contactRepository == null) contactRepository = new ContactRepositoryImp();
        return contactRepository;
    }


    @Override
    public Contact create(Contact contact) {
        this.contacts.add(contact);
        return contact;
    }

    @Override
    public Contact read(String contactId) {
        return search(contactId);
    }

    @Override
    public Contact update(Contact contact) {
        Contact contactTemp = search(contact.getContactId());
        if (contactTemp != null) {
            Contact contactNew = new Contact.Builder()
                    .copy(contactTemp)
                    .build();
            return contactNew;
        }
        return null;
    }

    @Override
    public void delete(String contactId) {
        Contact contact = search(contactId);
        if (contact != null) this.contacts.remove(contact);
    }

    @Override
    public Set<Contact> getAll() {
        return this.contacts;
    }

    public Contact search(final String contactId) {
        for (Contact contactSearch : this.contacts) {
            if (contactSearch.getContactId().equals(contactId))
                return contactSearch;
        }
        return null;
    }
}
